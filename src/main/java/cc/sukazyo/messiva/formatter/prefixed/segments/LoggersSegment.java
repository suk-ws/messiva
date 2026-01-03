package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.ILoggerInfo;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class LoggersSegment implements Segment {
	
	public static final LoggersSegment DEFAULT = new LoggersSegment(" :: ");
	
	@Nonnull
	private final String separator;
	
	private LoggersSegment (@Nonnull String separator) {
		this.separator = separator;
	}
	
	@Nonnull
	public static LoggersSegment withSeparator (@Nonnull String separator) {
		return new LoggersSegment(separator);
	}
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return log.context().get(ILoggerInfo.class)
				.map(logger -> {
					final String[] names = logger.getFullName();
					return Arrays.stream(names).reduce((a, b) -> a + separator + b)
							.orElse("");
				}).getOrElse(() -> "");
	}
	
}
