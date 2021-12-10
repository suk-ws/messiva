package cc.sukazyo.messiva.utils;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class StringUtils {
	
	@Nonnull
	public static String repeatChar (char c, int i) {
		final char[] chars = new char[i];
		Arrays.fill(chars, c);
		return new String(chars);
	}
	
}
