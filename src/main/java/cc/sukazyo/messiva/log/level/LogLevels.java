package cc.sukazyo.messiva.log.level;

import javax.annotation.Nonnull;

public enum LogLevels implements ILogLevel {
	
	ALL  (-Float.MAX_VALUE, "all"),
	TRACE(-10000f,          "trace"),
	DEBUG(-100f,            "debug"),
	INFO (0f,               "info"),
	WARN (1000f,            "warn"),
	ERROR(4000f,            "error"),
	FATAL(10000f,           "fatal"),
	NONE (Float.MAX_VALUE,  "none");
	
	static {
		
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.ALL,   "####");
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.DEBUG, "DBUG");
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.INFO,  "INFO");
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.WARN,  "WARN");
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.ERROR, "ERRO");
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.FATAL, "FTAL");
		LogLevelNameMapper.GLOBAL.mapName(LogLevels.NONE,  "!!!!");
		
		LogLevelNameMapper.SYMBOL.mapName(LogLevels.TRACE, "🔍");
		LogLevelNameMapper.SYMBOL.mapName(LogLevels.DEBUG, "🐛");
		LogLevelNameMapper.SYMBOL.mapName(LogLevels.INFO,  "ℹ️");
		LogLevelNameMapper.SYMBOL.mapName(LogLevels.WARN,  "⚠️");
		LogLevelNameMapper.SYMBOL.mapName(LogLevels.ERROR, "❌");
		LogLevelNameMapper.SYMBOL.mapName(LogLevels.FATAL, "💀");
		
	}
	
	public final float level;
	@Nonnull public final String id;
	
	LogLevels (float level, @Nonnull String id) {
		this.level = level;
		this.id = id;
	}
	
	@Override
	public float level () { return this.level; }
	
	@Nonnull
	@Override
	public String id () { return this.id; }
	
}
