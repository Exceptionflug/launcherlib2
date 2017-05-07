# LauncherLib
Library for accessing and changing the local launcher_profiles.json of the minecraftlauncher.

### How to start?

After you have setup the library you can easily get an instance of LauncherConfig.
```java
try {
    LauncherConfig launcherConfig = LauncherLib.load(configFile);
} catch(IOException e) {
    e.printstacktrace();
}
```
configFile is an instance of *java.io.File* which is simply the *launcher_profiles.json* file in *.minecraft*

### Add a new Profile
To add a new profile to the configuraion you have to get a new instance of Profile.
```java
Profile profile = launcherConfig.createProfile();
profile.setName(profileName);
profile.setLastVersionID(versionName);
```
profileName is the name of the profile which will be displayed in the dropdown menu of the launcher. The versionName is the name of the minecraft version which will be started (the folder names in *.minecraft/versions/*).


After you finished your profile you can add them to your LauncherConfig.
```java
launcherConfig.addProfile(profile);
```

### Add a new Account
To add a new Account to the config you have to do:
```java
Account account = launcherConfig.createAccount();
account.setDisplayName(displayName); //Works only on the legacy launcher
account.setUsername(username);
account.setUUID(uuid); //Works only on the legacy launcher
account.setUserid(userid); //Works only on the legacy launcher
account.setAccessToken(accessToken);
account.setIdentifier(UUIDTypeAdapter.fromUUID(UUID.fromString(uuid)));

launcherConfig.addAccount(account);
```
String displayName: The minecraft name of the account. If you want to use this on the new launcher you have to add a AccountProfile to the account.
String username: The e-mail address of the mojang account.
String uuid: The minecraft player uuid. This is only used by the legacy launcher.
String userid: The minecraft userid **(not the UUID!)**. This is only used by the legacy launcher.
String accessToken: The accessToken of that account.

Most of the information can be got by using the mojang apis.

### Set the selected profile & account
This will only set the selected account.
```java
SelectedUser sp = new SelectedUser();
sp.account = account.getIdentifier();
sp.profile = account.getIdentifier(); //Only for the new launcher. Don't use this for the legacy launcher!
sp.profile = launcherConfig.getSelectedUser().profile; //The legacy launcher method.
launcherConfig.setSelectedUser(sp);
```

If you want to set the selected profile you have to do this:
```java
profile.setLastUsed(MojangTimestampUtil.encode(System.currentTimeMillis())); //On the new launcher
sp.profile = profile.getIdentifier(); //On the legacy launcher.
```

### Get a profile
```java
Profile profile = launcherConfig.getProfile(profileIdentifier);
List<Profile> profiles = launcherConfig.getProfilesByVersionID(versionName);
```
String profileIdentifier: The identifier of the profile.
String versionName: versionName is the name of the minecraft version which will be started (the folder names in *.minecraft/versions/*).


### Save the changes
```java
try {
    LauncherLib.save(configFile, launcherConfig);
} catch(IOException e) {
    e.printStacktrace();
}
```
