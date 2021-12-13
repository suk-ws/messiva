package cc.sukazyo.messiva.log;

public enum LogLevel {
	
	TRACE(-1f, "TRAC"),
	DEBUG(-0.1f, "DBUG"),
	INFO(0f, "INFO"),
	WARN(0.5f, "WARN"),
	ERROR(1f, "ERRO"),
	FATAL(10f, "FTAL");
	
	public final float level;
	public final String tag;
	
	LogLevel (float level, String tag) {
		this.level = level;
		this.tag = tag;
	}
	
}
