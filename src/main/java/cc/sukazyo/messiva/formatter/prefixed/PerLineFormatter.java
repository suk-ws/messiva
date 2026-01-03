package cc.sukazyo.messiva.formatter.prefixed;

import cc.sukazyo.messiva.formatter.prefixed.segments.*;
import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.level.LogLevelNameMapper;

import javax.annotation.Nonnull;

public class PerLineFormatter extends PrefixedFormatter {
	
	@Nonnull
	private final Segment[] prefixes = Segment.of(
			DateTimeSegment.LOCAL_NORMAL, TextSegment.Space,
			TextSegment.of("@"), Segment.THREAD_NAME, TextSegment.Space,
			Segment.LOGGERS
	);
	
	@Nonnull
	private final Segment[] separators = Segment.of(
			Braces.Space.wrap(LogLevelSegment.useMapper(LogLevelNameMapper.SYMBOL))
	);
	
	@Nonnull
	private final TextSegment ongoing = TextSegment.Space;
	
	@Nonnull
	private final TextSegment ongoingSeparator = TextSegment.VerticalBar;
	
	@Nonnull
	@Override
	protected Segment[] getPrefixes (@Nonnull Log log) {
		return this.prefixes;
	}
	
	@Nonnull
	@Override
	protected Segment[] getSeparator (@Nonnull Log log) {
		return this.separators;
	}
	
	@Nonnull
	@Override
	protected Segment[] getOngoingPrefixes (@Nonnull Log log, @Nonnull String previous) {
		return Segment.of(this.ongoing.repeat(previous.length()));
	}
	
	@Nonnull
	@Override
	protected Segment[] getOngoingSeparator (@Nonnull Log log, @Nonnull String previous) {
		final int thisLen = this.ongoingSeparator.text.length();
		final int parentLen = previous.length();
		final int refill = parentLen - thisLen;
		return Segment.of(this.ongoing.repeat(refill), this.ongoingSeparator);
	}
	
}
