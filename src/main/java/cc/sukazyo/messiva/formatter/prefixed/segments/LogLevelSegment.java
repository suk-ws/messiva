package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.level.LogLevelNameMapper;

import javax.annotation.Nonnull;

public class LogLevelSegment implements Segment {
	
	public static final LogLevelSegment USE_GLOBAL = LogLevelSegment.useMapper(LogLevelNameMapper.GLOBAL);
	
	@Nonnull private final LogLevelNameMapper nameMapper;
	
	private LogLevelSegment (@Nonnull LogLevelNameMapper nameMapper) {
		this.nameMapper = nameMapper;
	}
	
	@Nonnull
	public static LogLevelSegment useMapper (@Nonnull LogLevelNameMapper nameMapper) {
		return new LogLevelSegment(nameMapper);
	}
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return nameMapper.getName(log.level());
	}
	
}
