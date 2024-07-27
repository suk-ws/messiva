package cc.sukazyo.messiva.appender;

import cc.sukazyo.messiva.formatter.ILogFormatter;

import javax.annotation.Nullable;

/**
 * @deprecated moved. use {@link cc.sukazyo.messiva.appender.impl.ConsoleAppender} instead.
 */
@Deprecated
public class ConsoleAppender extends cc.sukazyo.messiva.appender.impl.ConsoleAppender {
	
	public ConsoleAppender (@Nullable ILogFormatter formatter) {
		super(formatter);
	}
	
}
