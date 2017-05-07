package de.quantumnanox.launcherlib.api;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public enum LauncherVisibility {
	
	KEEP_LAUNCHER_OPEN("keep the launcher open"), CLOSE_LAUNCHER("close launcher when game starts"), REOPEN_ON_GAME_EXIT("hide launcher and re-open when game closes");
	
	private String lid;
	
	public static boolean legacyMode = false;

	private LauncherVisibility(String id) {
		this.lid = id;
	}

	public String getLegacyConfigID() {
		return lid;
	}

	@Override
	public String toString() {
		return lid;
	}
	
	public static LauncherVisibility getByLID(String lid) {
		for(LauncherVisibility v : values()) {
			if(v.lid.equals(lid)) return v;
		}
		return CLOSE_LAUNCHER;
	}
	
	public static class LauncherVisibilitySerializer implements JsonSerializer<LauncherVisibility> {

		@Override
		public JsonElement serialize(LauncherVisibility paramT, Type paramType, JsonSerializationContext paramJsonSerializationContext) {
			return new JsonPrimitive(paramT.getLegacyConfigID());
		}
		
	}
	
	public static class LauncherVisibilityDeserializer implements JsonDeserializer<LauncherVisibility> {

		@Override
		public LauncherVisibility deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext) throws JsonParseException {
			return getByLID(paramJsonElement.getAsString());
		}
		
	}
	
}
