package cc.sukazyo.messiva.logger.wrapper;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.AbstractLogger;
import cc.sukazyo.messiva.logger.Logger;

import javax.annotation.Nonnull;

/**
 * Base interface for wrap a logger to add new features.
 *
 * <p>
 *     All methods are forwarded to the wrapped logger returned by {@link #self()}.
 * </p>
 *
 * <h2>Implementation note</h2>
 *
 * <p>
 *     If a class implements this interface and returns itself in {@link #self()}, the compiler
 *     will incorrectly take every method in {@link AbstractLogger} and this interface as already
 *     implemented, although they are only default methods forwarding to {@link #self()}.
 * </p>
 *
 * <p>
 *     In this situation, it will create infinite recursion when call any method defined in
 *     {@link AbstractLogger}, causing a {@link StackOverflowError} eventually.
 * </p>
 *
 * <p>
 *     To avoid this and get a proper implements warning, you should implement {@link WrappedAbstractLogger}
 *     after every interfaces that extends this interface.That is a helper interface that
 *     re-declares all methods in {@link AbstractLogger} as abstract methods. By doing so, the
 *     compiler will require you to implement those methods properly, avoiding infinite recursion.
 * </p>
 *
 * <h2>Development note</h2>
 *
 * <p>
 *     Like saying before in the implementation note, if any default implementation of methods
 *     in {@link AbstractLogger} was added in this interface (as a forwarding method to {@link #self()}),
 *     you must add the same method as an abstract method in {@link WrappedAbstractLogger} as well.
 * </p>
 *
 */
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
	
}
