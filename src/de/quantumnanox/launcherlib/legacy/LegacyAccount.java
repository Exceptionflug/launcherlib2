package de.quantumnanox.launcherlib.legacy;

import java.util.List;

import de.quantumnanox.launcherlib.actual.AccountProfile;
import de.quantumnanox.launcherlib.api.Account;

public class LegacyAccount implements Account {

	private String accessToken;
	private transient String identifier;
	private String username;
	private String userid;
	private String uuid;
	private String displayName;

	@Override
	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public void setAccessToken(String token) {
		this.accessToken = token;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public void setIdentifier(String id) {
		this.identifier = id;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUserID(String id) {
		this.userid = id;
	}

	@Override
	public String getUserID() {
		return userid;
	}

	@Override
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String getUUID() {
		return uuid;
	}

	@Override
	public List<AccountProfile> getProfiles() {
		return null;
	}

	@Override
	public void setProfiles(List<AccountProfile> p) {
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void setDisplayName(String n) {
		this.displayName = n;
	}

}
