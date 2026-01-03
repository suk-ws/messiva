package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.ILoggerInfo;

import javax.annotation.Nonnull;

public class ThisLoggerNameSegment implements Segment {
	
	public static final ThisLoggerNameSegment INSTANCE = new ThisLoggerNameSegment();
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return log.context().get(ILoggerInfo.class)
				.map(ILoggerInfo::getName)
				.getOrElse(() -> "");
	}
	
}
