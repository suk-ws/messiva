package cc.sukazyo.messiva.log.level;

import javax.annotation.Nonnull;

public enum ExtraLogLevels implements ILogLevel {
	
	VERBOSE  (-80000f, "verbose"),
	// trace = -10000f
	// debug = -100f
	// info = 0f
	NOTICE   (250f,   "notice"),
	// warn = 1000f
	// fixme: This level is suspicious, may causing confusion with ERROR level, so that
	//  deprecated and need more discussions before reintroducing it.
//	ALERT  (2000f,  "alert"),
//	CAUTION   (3000f, "caution"),
	// error = 4000f
	CRITICAL (5000f, "critical");
	// fatal = 10000f
	
	static {
		
		LogLevelNameMapper.GLOBAL.mapName(VERBOSE,  "VBOS");
		LogLevelNameMapper.GLOBAL.mapName(NOTICE,   "NOTC");
//		LogLevelNameMapper.GLOBAL.mapName(ALERT,    "ALRT");
//		LogLevelNameMapper.GLOBAL.mapName(CAUTION,  "CAUT");
		LogLevelNameMapper.GLOBAL.mapName(CRITICAL, "CRIT");
		
		LogLevelNameMapper.SYMBOL.mapName(VERBOSE,  "🧻");
		LogLevelNameMapper.SYMBOL.mapName(NOTICE,   "📢");
//		LogLevelNameMapper.SYMBOL.mapName(ALERT,    "🚨");
//		LogLevelNameMapper.SYMBOL.mapName(CAUTION,  "🚨");
		LogLevelNameMapper.SYMBOL.mapName(CRITICAL, "🔥");
		
	}
	
	public final float level;
	@Nonnull public final String id;
	
	ExtraLogLevels (float level, @Nonnull String id) {
		this.level = level;
		this.id = id;
	}
	
	@Override
	public float level () { return this.level; }
	
	@Nonnull
	@Override
	public String id () { return this.id; }
	
}
