package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface Logger extends ILoggerInfo, ILoggerProvider {
	
	void log (@Nonnull Log log);
	
}
