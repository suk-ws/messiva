package cc.sukazyo.messiva.appender;

import cc.sukazyo.messiva.formatter.ILogFormatter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Appender implements IAppender {
	
	@Nullable public ILogFormatter formatter;
	
	public Appender (@Nullable ILogFormatter formatter) {
		this.formatter = formatter;
	}
	
	public Appender () {
		this(null);
	}
	
	@Nonnull
	public Appender setFormatter (@Nullable ILogFormatter formatter) {
		this.formatter = formatter;
		return this;
	}
	
}
