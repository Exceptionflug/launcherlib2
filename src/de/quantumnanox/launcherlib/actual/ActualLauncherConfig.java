package de.quantumnanox.launcherlib.actual;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.InstanceCreator;

import de.quantumnanox.launcherlib.api.Account;
import de.quantumnanox.launcherlib.api.LauncherConfig;
import de.quantumnanox.launcherlib.api.LauncherVersion;
import de.quantumnanox.launcherlib.api.Profile;
import de.quantumnanox.launcherlib.api.SelectedUser;
import de.quantumnanox.launcherlib.api.Settings;

public class ActualLauncherConfig implements LauncherConfig {
	
	private List<ActualProfile> profiles;
	private String clientToken;
	private List<ActualAccount> authenticationDatabase;
	private SelectedUser selectedUser;
	private LauncherVersion launcherVersion;
	private Settings settings;
	private int analyticsFailcount;
	private String analyticsToken;


	@Override
	public LauncherVersion getLauncherVersion() {
		return launcherVersion;
	}
	
	public void setLauncherVersion(LauncherVersion launcherVersion) {
		this.launcherVersion = launcherVersion;
	}

	@Override
	public List<Profile> getProfiles() {
		ArrayList<Profile> out = new ArrayList<>();
		for(ActualProfile ap : profiles) {
			out.add(ap);
		}
		return out;
	}

	@Override
	public void setProfiles(List<Profile> profiles) {
		ArrayList<ActualProfile> in = new ArrayList<>();
		for(Profile p : profiles) {
			if(p instanceof ActualProfile) {
				in.add((ActualProfile) p);
			}
		}
		this.profiles = in;
	}

	@Override
	public void addProfile(Profile p) {
		if(p instanceof ActualProfile) profiles.add((ActualProfile) p);
	}

	@Override
	public void removeProfile(Profile p) {
		profiles.remove(p);
	}

	@Override
	public Profile getProfile(String identifier) {
		for(ActualProfile p : profiles) {
			if(p.getIdentifier().equals(identifier)) return p;
		}
		return null;
	}

	@Override
	public List<Profile> getProfilesByVersionID(String versionID) {
		ArrayList<Profile> out = new ArrayList<>();
		for(ActualProfile ap : profiles) {
			try {
				if(ap.getLastVersionID().equals(versionID)) out.add(ap);
			} catch(Exception e) {
				continue;
			}
		}
		return out;
	}

	@Override
	public SelectedUser getSelectedUser() {
		return selectedUser;
	}

	@Override
	public void setSelectedUser(SelectedUser user) {
		this.selectedUser = user;
	}

	@Override
	public int getAnalyticsFailcount() {
		return analyticsFailcount;
	}

	@Override
	public void setAnalyticsFailcount(int i) {
		this.analyticsFailcount = i;
	}

	@Override
	public String getAnalyticsToken() {
		return analyticsToken;
	}

	@Override
	public void setAnalyticsToken(String token) {
		this.analyticsToken = token;
	}

	@Override
	public Settings getSettings() {
		return settings;
	}

	@Override
	public void setSettings(Settings s) {
		this.settings = s;
	}

	@Override
	public String getClientToken() {
		return clientToken;
	}

	@Override
	public void setClientToken(String token) {
		this.clientToken = token;
	}

	@Override
	public Profile createProfile() {
		return new ActualProfile();
	}

	@Override
	public Account createAccount() {
		return new ActualAccount();
	}

	@Override
	public List<Account> getAccounts() {
		ArrayList<Account> out = new ArrayList<>();
		for(ActualAccount ac : authenticationDatabase) {
			out.add(ac);
		}
		return out;
	}

	@Override
	public void setAccounts(List<Account> accs) {
		ArrayList<ActualAccount> in = new ArrayList<>();
		for(Account ac : accs) {
			if(ac instanceof ActualAccount) in.add((ActualAccount) ac);
		}
		this.authenticationDatabase = in;
	}

	@Override
	public void addAccount(Account acc) {
		if(acc instanceof ActualAccount) authenticationDatabase.add((ActualAccount) acc);
	}

	@Override
	public void removeAccount(Account acc) {
		authenticationDatabase.remove(acc);
	}

	@Override
	public Account getAccount(String identifier) {
		for(ActualAccount ac : authenticationDatabase) {
			if(ac.getIdentifier().equals(identifier)) return ac;
		}
		return null;
	}

	@Override
	public Account getAccountByUUID(String uuid) {
		for(ActualAccount ac : authenticationDatabase) {
			if(ac.getUUID().equals(uuid)) return ac;
		}
		return null;
	}
	
}
