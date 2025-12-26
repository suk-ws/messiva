package cc.sukazyo.messiva.utils;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Arrays;

public class StringUtils {
	
	@Nonnull
	public static String repeatChar (char c, int i) {
		final char[] chars = new char[i];
		Arrays.fill(chars, c);
		return new String(chars);
	}
	
	@Nonnull
	public static String[] lines (@Nonnull String message) {
		return message.split("\\n");
	}
	
	@Nonnull
	public static String repeat (@Nonnull String s, @Nonnegative int i) {
		final StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append(s);
		}
		return sb.toString();
	}
	
}
