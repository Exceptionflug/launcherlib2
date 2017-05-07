package de.quantumnanox.launcherlib.api;

import java.util.List;

import de.quantumnanox.launcherlib.actual.AccountProfile;

public interface Account {

	public String getAccessToken();
	public void setAccessToken(String token);
	
	public String getIdentifier();
	public void setIdentifier(String id);
	
	public void setUsername(String username);
	public String getUsername();
	
	@Legacy
	public void setUserID(String id);
	@Legacy
	public String getUserID();
	
	@Legacy
	public void setUUID(String uuid);
	@Legacy
	public String getUUID();
	
	@Actual
	public List<AccountProfile> getProfiles();
	@Actual
	public void setProfiles(List<AccountProfile> p);
	
	@Legacy
	public String getDisplayName();
	@Legacy
	public void setDisplayName(String n);
	
}
