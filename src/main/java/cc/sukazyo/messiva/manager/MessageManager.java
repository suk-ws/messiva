package cc.sukazyo.messiva.manager;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.ILoggerProvider;
import cc.sukazyo.messiva.logger.LogReceiver;
import cc.sukazyo.messiva.logger.Logger;
import cc.sukazyo.messiva.logger.ManagedLogger;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MessageManager implements ILoggerProvider, LogReceiver {
	
	private final List<LoggingContext> loggingContexts = new ArrayList<>();
	
	public void registerLoggingContext (@Nonnull LoggingContext context) {
		loggingContexts.add(context);
	}
	
	@Nonnull
	@Override
	public Logger getLogger (@Nonnull String name) {
		return new ManagedLogger(name, this);
	}
	
	@Override
	public void receiveLog (@Nonnull Log log) {
		for (LoggingContext context : loggingContexts) {
			context.put(log);
		}
	}
	
}
