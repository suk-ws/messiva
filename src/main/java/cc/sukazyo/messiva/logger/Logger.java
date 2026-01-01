package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.wrapper.ConcreteAbstractLogger;
import cc.sukazyo.messiva.logger.wrapper.LevelLoggingLoggerWrapper;

import javax.annotation.Nonnull;

/**
 * The main logger interface.
 *
 * <p>
 *     It extends {@link AbstractLogger} to provide basic logger functionalities,
 *     and {@link LevelLoggingLoggerWrapper} to add level-based logging capabilities.
 * </p>
 *
 * <h2>Implementation note</h2>
 *
 * <p>
 *     This interface extends {@link cc.sukazyo.messiva.logger.wrapper.LoggerWrapper},
 *     so that every implementation notes in there also applies to this interface.
 * </p>
 *
 * <p>
 *     In short, if you implement method {@link #self()} to return {@code this}, you should
 *     implement the helper interface {@link ConcreteAbstractLogger}
 *     at the most end to get proper warnings about unimplemented methods.
 * </p>
 */
public interface Logger extends AbstractLogger, LevelLoggingLoggerWrapper {
	
	default void log (@Nonnull Log log) {
		log.context().provide(ILoggerInfo.class, this);
		log.context().provide(Logger.class, this);
		this.receiveLog(log);
	}
	
}
