package cc.sukazyo.messiva.formatter.prefixed;

import cc.sukazyo.messiva.formatter.prefixed.segments.*;
import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class SimpleFormatter extends PrefixedFormatter {
	
	@Nonnull private final Segment[] prefixes = Segment.of(
			Braces.Square.wrap(DateTimeSegment.LOCAL_NORMAL),
			Braces.Square.wrap(Segment.LOGGERS),
			Braces.Square.wrap(Segment.THREAD_NAME),
			Braces.Square.wrap(Segment.LOG_LEVEL)
	);
	
	@Nonnull
	@Override
	protected Segment[] getPrefixes (@Nonnull Log log) {
		return prefixes;
	}
	
	@Nonnull
	@Override
	protected Segment[] getSeparator (@Nonnull Log log) {
		return Segment.of(TextSegment.Space);
	}
	
	@Nonnull
	@Override
	protected Segment[] getOngoingPrefixes (@Nonnull Log log, @Nonnull String previous) {
		return Segment.empty();
	}
	
	@Nonnull
	@Override
	protected Segment[] getOngoingSeparator (@Nonnull Log log, @Nonnull String previous) {
		return Segment.empty();
	}
	
}
