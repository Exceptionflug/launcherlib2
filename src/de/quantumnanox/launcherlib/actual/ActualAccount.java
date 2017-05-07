package de.quantumnanox.launcherlib.actual;

import java.util.List;

import com.mojang.util.UUIDTypeAdapter;

import de.quantumnanox.launcherlib.api.Account;

public class ActualAccount implements Account {

	private String accessToken;
	private transient String identifier;
	private String username;
	private transient List<AccountProfile> profiles;

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
		identifier = id;
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
	}

	@Override
	public String getUserID() {
		return null;
	}

	@Override
	public void setUUID(String uuid) {
	}

	@Override
	public String getUUID() {
		return UUIDTypeAdapter.fromString(identifier).toString();
	}

	@Override
	public List<AccountProfile> getProfiles() {
		return profiles;
	}

	@Override
	public void setProfiles(List<AccountProfile> p) {
		this.profiles = p;
	}

	@Override
	public String getDisplayName() {
		return profiles.get(0).getDisplayName();
	}

	@Override
	public void setDisplayName(String n) {
	}

}
