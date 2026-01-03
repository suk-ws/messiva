package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class ThreadNameSegment implements Segment {
	
	public static final ThreadNameSegment INSTANCE = new ThreadNameSegment();
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return log.thread().getName();
	}
	
}
