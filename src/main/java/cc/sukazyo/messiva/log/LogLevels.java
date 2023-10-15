package cc.sukazyo.messiva.log;

import javax.annotation.Nonnull;

public enum LogLevels implements ILogLevel {
	
	ALL  (-Float.MAX_VALUE, "####"),
	TRACE(-1f,       "TRAC"),
	DEBUG(-0.1f,     "DBUG"),
	INFO (0f,        "INFO"),
	WARN (0.5f,      "WARN"),
	ERROR(1f,        "ERRO"),
	FATAL(10f,       "FTAL"),
	NONE(Float.MAX_VALUE,  "!!!!");
	
	public final float level;
	@Nonnull public final String tag;
	
	LogLevels (float level, @Nonnull String tag) {
		this.level = level;
		this.tag = tag;
	}
	
	@Override
	public float level () { return this.level; }
	
	@Nonnull
	@Override
	public String tag () { return this.tag; }
	
}
