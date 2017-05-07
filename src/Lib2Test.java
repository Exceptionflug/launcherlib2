import java.io.File;
import java.io.IOException;

import de.quantumnanox.launcherlib.api.Account;
import de.quantumnanox.launcherlib.api.LauncherConfig;
import de.quantumnanox.launcherlib.api.LauncherLib;
import de.quantumnanox.launcherlib.api.Profile;

public class Lib2Test {
	
	public static void main(String[] args) throws IOException {
		LauncherConfig lc = LauncherLib.load(new File("C:/Users/Nico-/AppData/Roaming/.minecraft/launcher_profiles.json"));
		Profile p = lc.createProfile();
		p.setIdentifier("GiantMod fuer 1.10");
		p.setIcon("DIRT");
		p.setLastVersionID("GiantMod_1_10");
		p.setType("custom");
		p.setName("GiantMod fuer 1.10");
		lc.addProfile(p);
		LauncherLib.save(new File("C:/Users/Nico-/AppData/Roaming/.minecraft/launcher_profiles.json"), lc);
	}

}
