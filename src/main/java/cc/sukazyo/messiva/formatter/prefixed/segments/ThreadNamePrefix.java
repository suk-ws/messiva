package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class ThreadNamePrefix implements PrefixSegment {
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return Thread.currentThread().getName();
	}
	
}
