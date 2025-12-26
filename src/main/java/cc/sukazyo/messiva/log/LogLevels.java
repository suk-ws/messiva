package cc.sukazyo.messiva.log;

import javax.annotation.Nonnull;

public enum LogLevels implements ILogLevel {
	
	ALL  (-Float.MAX_VALUE, "all",   "####"),
	TRACE(-10000f,          "trace", "TRAC"),
	DEBUG(-100f,            "debug", "DBUG"),
	INFO (0f,               "info",  "INFO"),
	WARN (1000f,            "warn",  "WARN"),
	ERROR(4000f,            "error", "ERRO"),
	FATAL(10000f,           "fatal", "FTAL"),
	NONE (Float.MAX_VALUE,  "none",  "!!!!");
	
	public final float level;
	@Nonnull public final String id;
	@Nonnull public final String tag;
	
	LogLevels (float level, @Nonnull String id, @Nonnull String tag) {
		this.level = level;
		this.id = id;
		this.tag = tag;
	}
	
	@Override
	public float level () { return this.level; }
	
	@Nonnull
	@Override
	public String id () { return this.id; }
	
	@Nonnull
	@Override
	public String tag () { return this.tag; }
	
}
