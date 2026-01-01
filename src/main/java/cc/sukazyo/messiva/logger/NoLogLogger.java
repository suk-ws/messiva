package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.wrapper.WrappedAbstractLogger;

import javax.annotation.Nonnull;

public class NoLogLogger implements Logger, WrappedAbstractLogger {
	
	public static final NoLogLogger INSTANCE = new NoLogLogger();
	
	private final String name = "<no-log>";
	private final String[] fullName = new String[] { name };
	
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
	
	@Override
	public void receiveLog (@Nonnull Log log) {
		// do nothing
	}
	
	@Nonnull
	@Override
	public Logger getLogger (@Nonnull String name) {
		return INSTANCE;
	}
	
	@Override
	public void log (@Nonnull Log log) {
		// Do nothing
	}
	
}
