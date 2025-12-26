package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface PrefixSegment {
	@Nonnull String text(@Nonnull Log log);
}
