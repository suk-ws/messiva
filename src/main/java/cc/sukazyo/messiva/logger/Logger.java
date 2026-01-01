package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface Logger extends ILoggerInfo, ILoggerProvider, LogReceiver {
	
	default void log (@Nonnull Log log) {
		log.context().provide(ILoggerInfo.class, this);
		log.context().provide(Logger.class, this);
		this.receiveLog(log);
	}
	
}
