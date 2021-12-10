package cc.sukazyo.messiva.utils;

import java.util.Arrays;

public class StackUtils {
	
	public static StackTraceElement[] getStackTrace (int offset) {
		offset += 2;
		StackTraceElement[] origins = Thread.currentThread().getStackTrace();
		origins = Arrays.copyOfRange(origins, offset, origins.length);
		return origins;
	}
	
}
