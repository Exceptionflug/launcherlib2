package de.quantumnanox.launcherlib.legacy;

import java.util.ArrayList;
import java.util.List;

import de.quantumnanox.launcherlib.api.Account;
import de.quantumnanox.launcherlib.api.LauncherConfig;
import de.quantumnanox.launcherlib.api.LauncherVersion;
import de.quantumnanox.launcherlib.api.Profile;
import de.quantumnanox.launcherlib.api.SelectedUser;
import de.quantumnanox.launcherlib.api.Settings;

public class LegacyLauncherConfig implements LauncherConfig {
	
	private LauncherVersion launcherVersion;
	private List<LegacyProfile> profiles;
	private String identifier;
	private SelectedUser selectedUser;
	private String clientToken;
	private List<LegacyAccount> accounts;

	@Override
	public LauncherVersion getLauncherVersion() {
		return launcherVersion;
	}

	@Override
	public void setLauncherVersion(LauncherVersion version) {
		this.launcherVersion = version;
	}

	@Override
	public List<Profile> getProfiles() {
		ArrayList<Profile> out = new ArrayList<>();
		for(LegacyProfile lp : profiles) {
			out.add(lp);
		}
		return out;
	}

	@Override
	public void setProfiles(List<Profile> profiles) {
		ArrayList<LegacyProfile> in = new ArrayList<>();
		for(Profile p : profiles) {
			if(p instanceof LegacyProfile) in.add((LegacyProfile) p);
		}
		this.profiles = in;
	}

	@Override
	public void addProfile(Profile p) {
		if(p instanceof LegacyProfile) profiles.add((LegacyProfile) p);
	}

	@Override
	public void removeProfile(Profile p) {
		profiles.remove(p);
	}

	@Override
	public Profile getProfile(String identifier) {
		for(LegacyProfile lp : profiles) {
			if(lp.getIdentifier().equals(identifier)) return lp;
		}
		return null;
	}

	@Override
	public List<Profile> getProfilesByVersionID(String versionID) {
		ArrayList<Profile> out = new ArrayList<>();
		for(LegacyProfile lp : profiles) {
			if(lp.getLastVersionID().equals(versionID)) out.add(lp);
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
		return 0;
	}

	@Override
	public void setAnalyticsFailcount(int i) {
	}

	@Override
	public String getAnalyticsToken() {
		return null;
	}

	@Override
	public void setAnalyticsToken(String token) {
	}

	@Override
	public Settings getSettings() {
		return null;
	}

	@Override
	public void setSettings(Settings s) {
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
	public List<Account> getAccounts() {
		ArrayList<Account> out = new ArrayList<>();
		for(LegacyAccount la : accounts) {
			out.add(la);
		}
		return out;
	}

	@Override
	public void setAccounts(List<Account> accs) {
		ArrayList<LegacyAccount> in = new ArrayList<>();
		for(Account acc : accs) {
			if(acc instanceof LegacyAccount) in.add((LegacyAccount) acc);
		}
		accounts = in;
	}

	@Override
	public void addAccount(Account acc) {
		if(acc instanceof LegacyAccount) accounts.add((LegacyAccount) acc);
	}

	@Override
	public void removeAccount(Account acc) {
		accounts.remove(acc);
	}

	@Override
	public Account getAccount(String identifier) {
		for(LegacyAccount la : accounts) {
			if(la.getIdentifier().equals(identifier)) return la;
		}
		return null;
	}

	@Override
	public Account getAccountByUUID(String uuid) {
		for(LegacyAccount la : accounts) {
			if(la.getUUID().equals(uuid)) return la;
		}
		return null;
	}

	@Override
	public Profile createProfile() {
		return new LegacyProfile();
	}

	@Override
	public Account createAccount() {
		return new LegacyAccount();
	}

}
