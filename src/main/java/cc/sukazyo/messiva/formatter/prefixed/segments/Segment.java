package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface Segment {
	
	TimestampSegment TIMESTAMP = TimestampSegment.INSTANCE;
	DateTimeSegment DATE_TIME = DateTimeSegment.ISO;
	ThreadNameSegment THREAD_NAME = ThreadNameSegment.INSTANCE;
	StackLocationSegment STACK_LOCATION = StackLocationSegment.INSTANCE;
	ThisLoggerNameSegment THIS_LOGGER_NAME = ThisLoggerNameSegment.INSTANCE;
	LoggersSegment LOGGERS = LoggersSegment.DEFAULT;
	LogLevelSegment LOG_LEVEL = LogLevelSegment.USE_GLOBAL;
	
	Segment[] EMPTY_SEGMENTS = new Segment[0];
	
	@Nonnull String text(@Nonnull Log log);
	
	@Nonnull
	static Segment[] of (@Nonnull Segment... segments) {
		return segments;
	}
	
	@Nonnull
	static Segment[] empty () {
		return EMPTY_SEGMENTS;
	}
	
}
