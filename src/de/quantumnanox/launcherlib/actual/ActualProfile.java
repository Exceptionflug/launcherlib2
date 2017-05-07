package de.quantumnanox.launcherlib.actual;

import de.quantumnanox.launcherlib.api.LauncherVisibility;
import de.quantumnanox.launcherlib.api.Profile;
import de.quantumnanox.launcherlib.api.Resolution;

public class ActualProfile implements Profile {
	
	private transient String identifier;
	private String name;
	private String type;
	private String created;
	private String lastUsed;
	private String icon;
	private String lastVersionId;
	private String gameDir;
	private String javaDir;
	private String javaArgs;
	private Resolution resolution;

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getLastVersionID() {
		return lastVersionId;
	}

	@Override
	public String getCreated() {
		return created;
	}

	@Override
	public String getLastUsed() {
		return lastUsed;
	}

	@Override
	public String getJavaArgs() {
		return javaArgs;
	}

	@Override
	public String getJavaDir() {
		return javaDir;
	}

	@Override
	public LauncherVisibility getLauncherVisibility() {
		return null;
	}

	@Override
	public String getIcon() {
		return icon;
	}

	@Override
	public Resolution getResolution() {
		return resolution;
	}

	@Override
	public String[] getAllowedReleaseTypes() {
		return null;
	}

	@Override
	public void setIdentifier(String id) {
		this.identifier = id;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLastVersionID(String id) {
		this.lastVersionId = id;
	}

	@Override
	public void setCreated(String timestamp) {
		this.created = timestamp;
	}

	@Override
	public void setLastUsed(String timestamp) {
		this.lastUsed = timestamp;
	}

	@Override
	public void setJavaArgs(String args) {
		javaArgs = args;
	}

	@Override
	public void setJavaDir(String dir) {
		javaDir = dir;
	}

	@Override
	public void setLauncherVisibility(LauncherVisibility v) {
	}

	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public void setResolution(Resolution r) {
		resolution = r;
	}

	@Override
	public void setAllowedReleaseTypes(String[] args) {
	}

	@Override
	public void setGameDir(String dir) {
		this.gameDir = dir;
	}

	@Override
	public String getGameDir() {
		return gameDir;
	}

	
	
}
