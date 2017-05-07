package de.quantumnanox.launcherlib.api;

import java.util.List;

public interface LauncherConfig {
	
	public LauncherVersion getLauncherVersion();
	public void setLauncherVersion(LauncherVersion version);
	
	public List<Profile> getProfiles();
	public void setProfiles(List<Profile> profiles);
	public void addProfile(Profile p);
	public void removeProfile(Profile p);
	public Profile getProfile(String identifier);
	public List<Profile> getProfilesByVersionID(String versionID);
	
	public SelectedUser getSelectedUser();
	public void setSelectedUser(SelectedUser user);
	
	@Actual
	public int getAnalyticsFailcount();
	@Actual
	public void setAnalyticsFailcount(int i);
	@Actual
	public String getAnalyticsToken();
	@Actual
	public void setAnalyticsToken(String token);
	
	@Actual
	public Settings getSettings();
	@Actual
	public void setSettings(Settings s);
	
	public String getClientToken();
	public void setClientToken(String token);
	
	public List<Account> getAccounts();
	public void setAccounts(List<Account> accs);
	public void addAccount(Account acc);
	public void removeAccount(Account acc);
	public Account getAccount(String identifier);
	public Account getAccountByUUID(String uuid);
	
	
	public Profile createProfile();
	public Account createAccount();
	
}
