package de.quantumnanox.launcherlib.api;

public interface Profile {

	public String getIdentifier();
	
	public String getName();
	
	@Actual
	public String getType();
	
	public String getLastVersionID();
	
	@Actual
	public String getCreated();
	
	@Actual
	public String getLastUsed();
	
	public String getJavaArgs();
	
	public String getJavaDir();
	
	public LauncherVisibility getLauncherVisibility();
	
	@Actual
	public String getIcon();
	
	public Resolution getResolution();
	
	@Legacy
	public String[] getAllowedReleaseTypes();
	
	public void setIdentifier(String id);
	
	@Actual
	public void setType(String type);
	
	public void setName(String name);
	
	public void setLastVersionID(String id);
	
	@Actual
	public void setCreated(String timestamp);
	
	@Actual
	public void setLastUsed(String timestamp);
	
	public void setJavaArgs(String args);
	
	public void setJavaDir(String dir);
	
	public void setLauncherVisibility(LauncherVisibility v);
	
	@Actual
	public void setIcon(String icon);
	
	public void setResolution(Resolution r);
	
	@Legacy
	public void setAllowedReleaseTypes(String[] args);
	
	public void setGameDir(String dir);
	public String getGameDir();
	
}
