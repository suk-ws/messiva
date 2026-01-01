package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class StackLocationPrefix implements PrefixSegment {
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		final StackTraceElement[] stacks = log.stackTrace();
		return getSimpleName(stacks[0]);
	}
	
	private static String getSimpleName (@Nonnull StackTraceElement part) {
		final String[] classParts = part.getClassName().split("\\.");
		final String simpleClassName = classParts[classParts.length - 1];
		return simpleClassName + "#" + part.getMethodName();
	}
	
}
