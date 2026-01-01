package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface AbstractLogger extends ILoggerInfo, LoggerProvider, LogReceiver {
	
	default void log (@Nonnull Log log) {
		log.context().provide(ILoggerInfo.class, this);
		this.receiveLog(log);
	}
	
}
