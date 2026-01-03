package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.level.LogLevelNameMapper;

import javax.annotation.Nonnull;

public class LogLevelPrefix implements PrefixSegment {
	
	public static final LogLevelPrefix USE_GLOBAL = new LogLevelPrefix(LogLevelNameMapper.GLOBAL);
	
	@Nonnull private final LogLevelNameMapper nameMapper;
	
	public LogLevelPrefix (@Nonnull LogLevelNameMapper nameMapper) {
		this.nameMapper = nameMapper;
	}
	
	@Nonnull
	public static LogLevelPrefix useMapper (@Nonnull LogLevelNameMapper nameMapper) {
		return new LogLevelPrefix(nameMapper);
	}
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return nameMapper.getName(log.level());
	}
	
}
