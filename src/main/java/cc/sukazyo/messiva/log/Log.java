package cc.sukazyo.messiva.log;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import cc.sukazyo.messiva.log.message.IMessage;
import cc.sukazyo.std.contexts.GivenContext;
import cc.sukazyo.std.stacks.StacksExtensions;
import cc.sukazyo.std.stacks.WithCurrentStack;

import java.util.Arrays;
import java.util.function.Consumer;

@LoggingInternal
public class Log {
	
	@Nonnull private final IMessage message;
	@Nonnull private final ILogLevel level;
	private final long timestamp;
	@Nonnull private final Thread thread;
	@Nonnull private final StackTraceElement[] stackTrace;
	@Nonnull private final GivenContext context = GivenContext.apply();
	
	@Nonnull public IMessage message () { return this.message; }
	@Nonnull public ILogLevel level () { return this.level; }
	@Nonnegative public long timestamp () { return this.timestamp; }
	@Nonnull public Thread thread () { return this.thread; }
	@Nonnull public StackTraceElement[] rawStackTrace () { return this.stackTrace; }
	@Nonnull public GivenContext context () { return this.context; }
	
	/**
	 * Get the stack trace indicates where this log was created.
	 *
	 * <p>
	 *     This method will trim the internal logging classes ( classes marked with
	 *     {@link LoggingInternal}) to better indicates where the log was created in the REAL
	 *     application code.
	 * </p>
	 *
	 * <h2>Performance issues</h2>
	 *
	 * <p>
	 *     Due to it needs to check class annotations, it needs to get each stack trace element's
	 *     class definition from the {@link ClassLoader}. This makes this method significantly
	 *     SLOWER than just getting {@link #rawStackTrace() the raw stack trace}.
	 * </p>
	 *
	 * <p>
	 *     Due to it does heavy works, you should avoid calling this method multiple times.
	 *     Instead, call it once and cache the result if you need to use it multiple times.
	 * </p>
	 *
	 * @see LoggingInternal If you want to know deeper about why and how it trims stacks and
	 *                      get the real stacks for application code.
	 */
	@Nonnull public StackTraceElement[] stackTrace () {
		final StackTraceElement[] stacks = rawStackTrace();
		int cutIndex = 0;
		while (true) {
			if (cutIndex == stacks.length) break;
			final StackTraceElement element = stacks[cutIndex];
			try {
				final Class<?> cls = ClassLoader.getSystemClassLoader().loadClass(element.getClassName());
				if (cls.getAnnotation(LoggingInternal.class) == null) {
					break;
				} else {
					cutIndex++;
				}
			} catch (ClassNotFoundException e) {
				break;
			}
		}
		return Arrays.copyOfRange(stacks, cutIndex, stacks.length);
	}
	
	private Log (
			@Nonnull IMessage message, @Nonnull ILogLevel level,
			@Nonnull Thread thread, long timestamp, @Nonnull StackTraceElement[] stackTrace
	) {
		this.message = message;
		this.level = level;
		this.thread = thread;
		this.timestamp = timestamp;
		this.stackTrace = stackTrace;
	}
	
	public Log (
			@Nonnull IMessage message, @Nonnull ILogLevel level,
			@Nonnull Thread thread, long timestamp
	) {
		this(
				message, level, thread, timestamp,
				WithCurrentStack.getStackTrace(0)
		);
	}
	
	public Log (@Nonnull ILogLevel level, @Nonnull IMessage message) {
		this(
				message, level,
				Thread.currentThread(),
				System.currentTimeMillis()
		);
	}
	
//	public Log (@Nonnull IMessage message, @Nonnull ILogLevel level, @Nonnull Thread thread) {
//		this(message, level, thread, System.currentTimeMillis());
//	}
//
//	public Log (@Nonnull IMessage message, @Nonnull ILogLevel level) {
//		this(message, level, Thread.currentThread());
//	}

//	/// #block old_constructors
//	/// for old Message
//
//	@Deprecated
//	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
//	@Nonnull Thread thread,long timestamp, @Nonnull StackTraceElement[] stackTrace) {
//		this.message = message;
//		this.level = level;
//		this.thread = thread;
//		this.timestamp = timestamp;
//		this.stackTrace = stackTrace;
//	}
//
//	@Deprecated
//	public Log (@Nonnegative int stackOffset,
//	@Nonnull Message message, @Nonnull ILogLevel level,
//	@Nonnull Thread thread, long timestamp) {
//		this(message, level, thread, timestamp, WithCurrentStack.getStackTrace(stackOffset+2));
//	}
//
//	@Deprecated
//	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
//	@Nonnull Thread thread, long timestamp) {
//		this(1, message, level, thread, timestamp);
//	}
//
//	@Deprecated
//	public Log (@Nonnegative int stackOffset,
//	@Nonnull Message message, @Nonnull ILogLevel level,
//	@Nonnull Thread thread) {
//		this(stackOffset+1, message, level, thread, System.currentTimeMillis());
//	}
//
//	@Deprecated
//	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
//	@Nonnull Thread thread) {
//		this(1, message, level, thread);
//	}
//
//	@Deprecated
//	public Log( @Nonnegative int stackOffset, @Nonnull Message message, @Nonnull ILogLevel level){
//		this(stackOffset + 1, message, level, Thread.currentThread());
//	}
//
//	@Deprecated
//	public Log (@Nonnull Message message, @Nonnull ILogLevel level) {
//		this(1, message, level);
//	}
//
//	/// #endblock old_constructors
	
	public Log withContext (@Nonnull Consumer<GivenContext> consumer) {
		consumer.accept(this.context());
		return this;
	}
	
}
