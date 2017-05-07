package de.quantumnanox.launcherlib.actual;

import java.lang.reflect.Type;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

public class AccountProfile {

	private transient String identifier;
	private String displayName;
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
}
