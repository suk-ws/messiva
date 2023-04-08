package cc.sukazyo.messiva.formatter;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface ILogFormatter {
	
	@Nonnull
	String format(@Nonnull Log log);
	
}
