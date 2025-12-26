package cc.sukazyo.messiva.log;

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
