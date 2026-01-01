package cc.sukazyo.messiva.manager;

import cc.sukazyo.messiva.logger.Logger;
import cc.sukazyo.messiva.logger.LoggerProvider;
import cc.sukazyo.messiva.logger.NoLogLogger;

import javax.annotation.Nonnull;

public class NoLog implements LoggerProvider {
	
	public static final NoLog INSTANCE = new NoLog();
	
	@Nonnull
	@Override
	public Logger getLogger (@Nonnull String name) {
		return NoLogLogger.INSTANCE;
	}
	
}
