package cc.sukazyo.messiva.formatter.prefixed;

import cc.sukazyo.messiva.formatter.prefixed.segments.PrefixSegment;
import cc.sukazyo.messiva.formatter.prefixed.segments.PrefixTexts;
import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class BasePrefixedFormatter extends PrefixedFormatter {
	
	@Nonnull private final PrefixSegment[] segments;
	@Nonnull private final PrefixSegment[] separator;
	
	private BasePrefixedFormatter(@Nonnull PrefixSegment[] segments, @Nonnull PrefixSegment[] separator) {
		this.segments = segments;
		this.separator = separator;
	}
	
	@Nonnull
	public static BasePrefixedFormatter with (@Nonnull PrefixSegment[] segments, @Nonnull PrefixSegment[] separator) {
		return new BasePrefixedFormatter(segments, separator);
	}
	
	@Nonnull
	@Override
	protected PrefixSegment[] getPromptPrefixes (@Nonnull Log log) {
		return segments;
	}
	
	@Nonnull
	@Override
	protected PrefixSegment[] getOngoingPrefixes (@Nonnull Log log, @Nonnull String promptPrefix) {
		return new PrefixSegment[]{ PrefixTexts.Space.repeat(promptPrefix.length()) };
	}
	
	@Nonnull
	@Override
	protected PrefixSegment[] getSeparatorPrefixes (@Nonnull Log log) {
		return separator;
	}
	
}
