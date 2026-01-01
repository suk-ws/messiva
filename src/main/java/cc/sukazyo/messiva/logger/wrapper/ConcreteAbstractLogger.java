package cc.sukazyo.messiva.logger.wrapper;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.AbstractLogger;
import cc.sukazyo.messiva.logger.Logger;

import javax.annotation.Nonnull;

public interface ConcreteAbstractLogger extends AbstractLogger {
	
	@Nonnull
	@Override
	String getName ();
	
	@Nonnull
	@Override
	String[] getFullName ();
	
	@Nonnull
	@Override
	Logger getLogger (@Nonnull String name);
	
	@Override
	void receiveLog (@Nonnull Log log);
	
}
