package de.quantumnanox.launcherlib.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MojangTimestampUtil {

	public static String encode(long time) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss.SSS");
		Date d = new Date(time);
		return df1.format(d).concat("T").concat(df2.format(d)).concat("Z");
	}
	
	public static long decode(String stamp) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
		stamp = stamp.replace("T", "-").replace("Z", "");
		try {
			return df1.parse(stamp).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
