package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.manager.MessageManager;

import javax.annotation.Nonnull;

public class ManagedLogger implements Logger {
	
	@Nonnull private final MessageManager logReceiver;
	@Nonnull private final String name;
	
	public ManagedLogger (@Nonnull String name, @Nonnull MessageManager logReceiver) {
		this.name = name;
		this.logReceiver = logReceiver;
	}
	
	@Nonnull
	@Override
	public String getName () {
		return name;
	}
	
	@Nonnull
	@Override
	public String[] getFullName () {
		return new String[] { name };
	}
	
	@Nonnull
	@Override
	public Logger getLogger (@Nonnull String name) {
		throw new UnsupportedOperationException("ManagedLogger does not support getLogger");
	}
	
	@Override
	public void log (@Nonnull Log log) {
		logReceiver.receiveLog(log);
	}
	
}
