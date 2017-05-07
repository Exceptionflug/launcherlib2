package de.quantumnanox.launcherlib.legacy;

import de.quantumnanox.launcherlib.api.LauncherVisibility;
import de.quantumnanox.launcherlib.api.Profile;
import de.quantumnanox.launcherlib.api.Resolution;

public class LegacyProfile implements Profile {

	private String name;
	private String lastVersionId;
	private String javaArgs;
	private String javaDir;
	private LauncherVisibility launcherVisibility;
	private Resolution resolution;
	private String[] allowedReleaseTypes;
	private String gameDir;

	@Override
	public String getIdentifier() {
		return name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return "legacy";
	}

	@Override
	public String getLastVersionID() {
		return lastVersionId;
	}

	@Override
	public String getCreated() {
		return null;
	}

	@Override
	public String getLastUsed() {
		return null;
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
		return launcherVisibility;
	}

	@Override
	public String getIcon() {
		return null;
	}

	@Override
	public Resolution getResolution() {
		return resolution;
	}

	@Override
	public String[] getAllowedReleaseTypes() {
		return allowedReleaseTypes;
	}

	@Override
	public void setIdentifier(String id) {
	}

	@Override
	public void setType(String type) {
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLastVersionID(String id) {
		lastVersionId = id;
	}

	@Override
	public void setCreated(String timestamp) {
	}

	@Override
	public void setLastUsed(String timestamp) {
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
		launcherVisibility = v;
	}

	@Override
	public void setIcon(String icon) {
	}

	@Override
	public void setResolution(Resolution r) {
		resolution = r;
	}

	@Override
	public void setAllowedReleaseTypes(String[] args) {
		allowedReleaseTypes = args;
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
