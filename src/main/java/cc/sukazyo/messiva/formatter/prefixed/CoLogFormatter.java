package cc.sukazyo.messiva.formatter.prefixed;

import cc.sukazyo.messiva.formatter.prefixed.segments.*;
import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.level.LogLevelNameMapper;
import cc.sukazyo.messiva.utils.WCWidth;

import javax.annotation.Nonnull;

public class CoLogFormatter extends PrefixedFormatter {
	
	@Nonnull
	private final Segment[] prefixes = Segment.of(
			DateTimeSegment.LOCAL_NORMAL, TextSegment.Space,
			TextSegment.of("@"), Segment.THREAD_NAME, TextSegment.Space,
			Segment.LOGGERS
	);
	
	@Nonnull
	@Override
	protected Segment[] getPrefixes (@Nonnull Log log) {
		return prefixes;
	}
	
	@Nonnull
	@Override
	protected Segment[] getSeparator (@Nonnull Log log) {
		return Segment.of(
				TextSegment.Space,
				Braces.Square.wrap(LogLevelSegment.useMapper(LogLevelNameMapper.SYMBOL)),
				TextSegment.Space
		);
	}
	
	@Nonnull
	@Override
	protected Segment[] getOngoingPrefixes (@Nonnull Log log, @Nonnull String previous) {
		return Segment.of(TextSegment.Space.repeat(WCWidth.wcwidth(previous)));
	}
	
	@Nonnull
	@Override
	protected Segment[] getOngoingSeparator (@Nonnull Log log, @Nonnull String previous) {
		return Segment.of(
				TextSegment.Space,
				Braces.Space.wrap(TextSegment.VerticalBar),
				TextSegment.Space
		);
	}
	
}
