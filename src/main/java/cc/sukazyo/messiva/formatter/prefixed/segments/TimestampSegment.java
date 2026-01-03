package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class TimestampSegment implements Segment {
	
	public static final TimestampSegment INSTANCE = new TimestampSegment();
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return String.valueOf(log.timestamp());
	}
	
}
