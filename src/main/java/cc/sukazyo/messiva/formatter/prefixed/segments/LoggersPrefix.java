package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.ILoggerInfo;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class LoggersPrefix implements PrefixSegment {
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return log.context().get(ILoggerInfo.class)
				.map(logger -> {
					final String[] names = logger.getFullName();
					return Arrays.stream(names).reduce((a, b) -> a + "::" + b)
							.orElse("");
				}).getOrElse(() -> "");
	}
	
}
