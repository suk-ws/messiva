package cc.sukazyo.messiva.log;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import cc.sukazyo.messiva.log.message.IMessage;
import cc.sukazyo.std.contexts.GivenContext;
import cc.sukazyo.std.stacks.StacksExtensions;
import cc.sukazyo.std.stacks.WithCurrentStack;

import java.util.Arrays;
import java.util.function.Consumer;

public class Log {
	
	
	public static class Initializing {}
	
	public static class StackOffset {
		public int value = 0;
	}
	
	/** @deprecated Will be private. Use method with the same name instead. */
	@Deprecated @Nonnull public final IMessage message;
	/** @deprecated Will be private. Use method with the same name instead. */
	@Deprecated @Nonnull public final ILogLevel level;
	/** @deprecated Will be private. Use method with the same name instead. */
	@Deprecated public final long timestamp;
	/** @deprecated Will be private. Use method with the same name instead. */
	@Deprecated @Nonnull public final Thread thread;
	/** @deprecated Will be private. Use method with the same name instead. */
	@Deprecated @Nonnull public final StackTraceElement[] stackTrace;
	@Nonnull private final GivenContext context = GivenContext.apply();
	{ context.ownedBy(Initializing.class).provide(StackOffset.class, new StackOffset()); }
	
	@Nonnull public IMessage message () { return this.message; }
	@Nonnull public ILogLevel level () { return this.level; }
	@Nonnegative public long timestamp () { return this.timestamp; }
	@Nonnull public Thread thread () { return this.thread; }
	@Nonnull public StackTraceElement[] stackTrace () {
		return Arrays.copyOfRange(
				this.stackTrace,
				this.context.ownedBy(Initializing.class).getUnsafe(StackOffset.class).value,
				this.stackTrace.length
		);
	}
	@Nonnull public GivenContext context () { return this.context; }
	
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
				StacksExtensions.dropWhileClass(Log.class, WithCurrentStack.getStackTrace(0))
		);
	}
	
	public Log (@Nonnull IMessage message, @Nonnull ILogLevel level, @Nonnull Thread thread) {
		this(message, level, thread, System.currentTimeMillis());
	}
	
	public Log (@Nonnull IMessage message, @Nonnull ILogLevel level) {
		this(message, level, Thread.currentThread());
	}
	
	/// #block old_constructors
	/// for old Message
	
	@Deprecated
	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread,long timestamp, @Nonnull StackTraceElement[] stackTrace) {
		this.message = message;
		this.level = level;
		this.thread = thread;
		this.timestamp = timestamp;
		this.stackTrace = stackTrace;
	}
	
	@Deprecated
	public Log (@Nonnegative int stackOffset,
	@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread, long timestamp) {
		this(message, level, thread, timestamp, WithCurrentStack.getStackTrace(stackOffset+2));
	}
	
	@Deprecated
	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread, long timestamp) {
		this(1, message, level, thread, timestamp);
	}
	
	@Deprecated
	public Log (@Nonnegative int stackOffset,
	@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread) {
		this(stackOffset+1, message, level, thread, System.currentTimeMillis());
	}
	
	@Deprecated
	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread) {
		this(1, message, level, thread);
	}
	
	@Deprecated
	public Log( @Nonnegative int stackOffset, @Nonnull Message message, @Nonnull ILogLevel level){
		this(stackOffset + 1, message, level, Thread.currentThread());
	}
	
	@Deprecated
	public Log (@Nonnull Message message, @Nonnull ILogLevel level) {
		this(1, message, level);
	}
	
	/// #endblock old_constructors
	
	public Log withContext (@Nonnull Consumer<GivenContext> consumer) {
		consumer.accept(this.context());
		return this;
	}
	
}
