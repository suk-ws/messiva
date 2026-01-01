package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;
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
 *     The {@link LevelLoggingLoggerWrapper} is a {@link cc.sukazyo.messiva.logger.wrapper.LoggerWrapper},
 *     which provides default implementations for all methods in {@link AbstractLogger} by
 *     delegating them to an underlying {@link AbstractLogger} instance.
 * </p>
 *
 * <p>
 *     This causes a problem that when a logger's {@code self()} method returns {@code this},
 *     the Java compiler will not warn you if you do not provide implementations for the methods
 *     in {@link AbstractLogger}, because the default implementations from
 *     {@link LevelLoggingLoggerWrapper} will be used, and all of them delegate to {@code self()},
 *     which creates a circular delegation, leading to a {@link StackOverflowError} when any
 *     method is called.
 * </p>
 *
 * <p>
 *     So that, if your logger's {@code self()} method returns {@code this}, you MUST provide
 *     implementations for all methods in {@link AbstractLogger} to avoid circular delegation.
 * </p>
 *
 * <p>
 *     A simple way to ensure this is to implements {@link AbstractLogger} first, and then
 *     change the interface to this {@code Logger} interface after every method is implemented.
 *     But this method has a little problem that when the {@link AbstractLogger} interface changes,
 *     the compiler will not warn you to update your implementation class accordingly, and then
 *     every call to the missing methods will lead to {@link StackOverflowError} at runtime.
 *     You must watch the update of {@link AbstractLogger} manually and update your
 *     implementation class in-time.
 * </p>
 *
 * <p>
 *     Or else, you can split your implementation into two classes: one implements
 *     {@link AbstractLogger} and provides all the necessary implementations, and the other
 *     extends the first class and implements this {@code Logger} interface, with the
 *     {@code self()} method returning the first class instance. This method is safer because
 *     when the {@link AbstractLogger} interface changes, the compiler will warn you
 *     to update your implementation class accordingly.
 * </p>
 */
public interface Logger extends AbstractLogger, LevelLoggingLoggerWrapper {
	
	default void log (@Nonnull Log log) {
		log.context().provide(ILoggerInfo.class, this);
		log.context().provide(Logger.class, this);
		this.receiveLog(log);
	}
	
}
