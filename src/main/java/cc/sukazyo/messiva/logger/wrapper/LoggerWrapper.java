package cc.sukazyo.messiva.logger.wrapper;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.AbstractLogger;
import cc.sukazyo.messiva.logger.Logger;

import javax.annotation.Nonnull;

public interface LoggerWrapper extends AbstractLogger {
	
	@Nonnull
	AbstractLogger self ();
	
	@Nonnull
	@Override
	default String getName () {
		return self().getName();
	}
	
	@Nonnull
	@Override
	default String[] getFullName () {
		return self().getFullName();
	}
	
	@Nonnull
	@Override
	default Logger getLogger (@Nonnull String name) {
		return self().getLogger(name);
	}
	
	@Override
	default void receiveLog (@Nonnull Log log) {
		self().receiveLog(log);
	}
	
	@Override
	default void log (@Nonnull Log log) {
		self().log(log);
	}
	
}
