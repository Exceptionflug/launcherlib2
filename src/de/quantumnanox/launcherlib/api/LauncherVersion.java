package de.quantumnanox.launcherlib.api;

public class LauncherVersion {
	
	private String name;
	private int format;
	private int profilesFormat;
	
	public int getFormat() {
		return format;
	}
	
	public String getName() {
		return name;
	}
	
	public int getProfilesFormat() {
		return profilesFormat;
	}
	
	public void setFormat(int format) {
		this.format = format;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setProfilesFormat(int profilesFormat) {
		this.profilesFormat = profilesFormat;
	}
	
}
