package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.wrapper.WrappedAbstractLogger;
import cc.sukazyo.messiva.manager.MessageManager;

import javax.annotation.Nonnull;

public class ManagedLogger implements Logger, WrappedAbstractLogger {
	
	@Nonnull private final MessageManager logReceiver;
	@Nonnull private final String name;
	@Nonnull private final String[] fullName;
	
	public ManagedLogger (@Nonnull String name, @Nonnull MessageManager logReceiver) {
		this.name = name;
		this.fullName = new String[] { name };
		this.logReceiver = logReceiver;
	}
	
	@Nonnull
	@Override
	public AbstractLogger self () {
		return this;
	}
	
	@Nonnull
	@Override
	public String getName () {
		return name;
	}
	
	@Nonnull
	@Override
	public String[] getFullName () {
		return fullName;
	}
	
	@Nonnull
	@Override
	public Logger getLogger (@Nonnull String name) {
		return new SubLogger(this, name);
	}
	
	@Override
	public void receiveLog (@Nonnull Log log) {
		logReceiver.receiveLog(log);
	}
	
}
