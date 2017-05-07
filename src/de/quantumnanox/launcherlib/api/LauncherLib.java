package de.quantumnanox.launcherlib.api;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import de.quantumnanox.launcherlib.actual.AccountProfile;
import de.quantumnanox.launcherlib.actual.ActualAccount;
import de.quantumnanox.launcherlib.actual.ActualLauncherConfig;
import de.quantumnanox.launcherlib.legacy.LegacyLauncherConfig;

public class LauncherLib {

	public static LauncherConfig load(File f) throws IOException {
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LauncherVisibility.LauncherVisibilityDeserializer.class, new LauncherVisibility.LauncherVisibilityDeserializer()).registerTypeAdapter(LauncherVisibility.LauncherVisibilitySerializer.class, new LauncherVisibility.LauncherVisibilitySerializer()).create();
		FileReader fr = new FileReader(f);
		JsonReader jr = new JsonReader(fr);
		JsonParser jp = new JsonParser();
		JsonObject root = jp.parse(jr).getAsJsonObject();
		JsonObject version = root.getAsJsonObject("launcherVersion");
		LauncherVersion lv = gson.fromJson(version, LauncherVersion.class);
		
		LauncherConfig out = null;
		
		if(lv.getProfilesFormat() == 1) {
			out = new LegacyLauncherConfig();
		} else {
			out = new ActualLauncherConfig();
		}
		
		//LAUNCHER-VERSION
		out.setLauncherVersion(lv);
		
		//PROFILES
		out.setProfiles(new ArrayList<>());
		JsonObject profiles = root.getAsJsonObject("profiles");
		for(Entry<String, JsonElement> je : profiles.entrySet()) {
			Profile p = gson.fromJson(je.getValue(), out.createProfile().getClass());
			p.setIdentifier(je.getKey());
			out.addProfile(p);
		}
		
		//CLIENT-TOKEN
		out.setClientToken(root.get("clientToken").getAsString());
		
		//SELECTED-USER
		JsonElement selected = null;
		if(out instanceof ActualLauncherConfig) {
			selected = root.getAsJsonObject("selectedUser");
			out.setSelectedUser(gson.fromJson(selected, SelectedUser.class));
		} else {
			selected = root.get("selectedUser");
			SelectedUser sel = new SelectedUser();
			sel.account = selected.getAsString();
			sel.profile = root.get("selectedProfile").getAsString();
			out.setSelectedUser(sel);
		}
		
		//AUTHENTICATION-DATABASE
		out.setAccounts(new ArrayList<>());
		JsonObject authDB = root.getAsJsonObject("authenticationDatabase");
		for(Entry<String, JsonElement> je : authDB.entrySet()) {
			Account acc = gson.fromJson(je.getValue(), out.createAccount().getClass());
			acc.setIdentifier(je.getKey());
			if(out instanceof ActualLauncherConfig) {
				ArrayList<AccountProfile> pros = new ArrayList<>();
				JsonObject accPro = je.getValue().getAsJsonObject().getAsJsonObject("profiles");
				for(Entry<String, JsonElement> je2 : accPro.entrySet()) {
					AccountProfile acp = gson.fromJson(je2.getValue(), AccountProfile.class);
					acp.setIdentifier(je2.getKey());
					pros.add(acp);
				}
				acc.setProfiles(pros);
			}
			out.addAccount(acc);
		}
		
		//SETTINGS
		if(out instanceof ActualLauncherConfig) {
			JsonObject settings = root.getAsJsonObject("settings");
			out.setSettings(gson.fromJson(settings, Settings.class));
		}
		
		//ANALYTICS
		if(out instanceof ActualLauncherConfig) {
			out.setAnalyticsFailcount(root.get("analyticsFailcount").getAsInt());
			out.setAnalyticsToken(root.get("analyticsToken").getAsString());
		}
		
		return out;
	}
	
	public static void save(File f, LauncherConfig lc) throws IOException {
		Gson gson = new GsonBuilder().registerTypeAdapter(LauncherVisibility.LauncherVisibilityDeserializer.class, new LauncherVisibility.LauncherVisibilityDeserializer()).registerTypeAdapter(LauncherVisibility.LauncherVisibilitySerializer.class, new LauncherVisibility.LauncherVisibilitySerializer()).setPrettyPrinting().disableHtmlEscaping().create();
		JsonParser jp = new JsonParser();
		
		//ROOT
		JsonObject root = new JsonObject();
		
		//PROFILES
		JsonObject profiles = new JsonObject();
		for(Profile p : lc.getProfiles()) {
			JsonObject obj = jp.parse(gson.toJson(p, p.getClass())).getAsJsonObject();
			profiles.add(p.getIdentifier(), obj);
		}
		root.add("profiles", profiles);
		
		//CLIENT-TOKEN
		root.add("clientToken", new JsonPrimitive(lc.getClientToken()));
		
		//AUTHENTICATION-DATABASE
		JsonObject authDB = new JsonObject();
		for(Account acc : lc.getAccounts()) {
			JsonObject obj = jp.parse(gson.toJson(acc, acc.getClass())).getAsJsonObject();
			if(acc instanceof ActualAccount) {
				JsonObject pros = new JsonObject();
				for(AccountProfile ap : acc.getProfiles()) {
					pros.add(ap.getIdentifier(), jp.parse(gson.toJson(ap, AccountProfile.class)));
				}
				obj.add("profiles", pros);
			}
			authDB.add(acc.getIdentifier(), obj);
		}
		root.add("authenticationDatabase", authDB);
		
		//SELECTED-USER
		if(lc instanceof ActualLauncherConfig) {
			root.add("selectedUser", jp.parse(gson.toJson(lc.getSelectedUser(), SelectedUser.class)));
		} else {
			root.add("selectedUser", new JsonPrimitive(lc.getSelectedUser().account));
			root.add("selectedProfile", new JsonPrimitive(lc.getSelectedUser().profile));
		}
		
		//LAUNCHER-VERSION
		JsonObject version = jp.parse(gson.toJson(lc.getLauncherVersion(), LauncherVersion.class)).getAsJsonObject();
		root.add("launcherVersion", version);
		
		//SETTINGS
		if(lc instanceof ActualLauncherConfig) {
			root.add("settings", jp.parse(gson.toJson(lc.getSettings(), Settings.class)));
		}
		
		//ANALYTICS
		if(lc instanceof ActualLauncherConfig) {
			root.add("analyticsFailcount", new JsonPrimitive(lc.getAnalyticsFailcount()));
			root.add("analyticsToken", new JsonPrimitive(lc.getAnalyticsToken()));
		}
		
		f.createNewFile();
		JsonWriter jw = new JsonWriter(new FileWriter(f));
		jw.setIndent("  ");
		gson.toJson(root, jw);
		jw.close();
	}
	
}
