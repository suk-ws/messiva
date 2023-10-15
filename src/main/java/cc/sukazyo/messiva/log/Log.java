package cc.sukazyo.messiva.log;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import cc.sukazyo.messiva.utils.StackUtils;

public class Log {
	
	@Nonnull public final Message message;
	@Nonnull public final ILogLevel level;
	public final long timestamp;
	@Nonnull public final Thread thread;
	@Nonnull public final StackTraceElement[] stackTrace;
	
	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread,long timestamp, @Nonnull StackTraceElement[] stackTrace) {
		this.message = message;
		this.level = level;
		this.thread = thread;
		this.timestamp = timestamp;
		this.stackTrace = stackTrace;
	}
	
	public Log (@Nonnegative int stackOffset,
	@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread, long timestamp) {
		this(message, level, thread, timestamp, StackUtils.getStackTrace(stackOffset+1));
	}
	
	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread, long timestamp) {
		this(1, message, level, thread, timestamp);
	}
	
	public Log (@Nonnegative int stackOffset,
	@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread) {
		this(stackOffset+1, message, level, thread, System.currentTimeMillis());
	}
	
	public Log (@Nonnull Message message, @Nonnull ILogLevel level,
	@Nonnull Thread thread) {
		this(1, message, level, thread);
	}
	
	public Log (@Nonnegative int stackOffset,
	@Nonnull Message message, @Nonnull ILogLevel level) {
		this(stackOffset+1, message, level, Thread.currentThread());
	}
	
	public Log (@Nonnull Message message, @Nonnull ILogLevel level) {
		this(1, message, level);
	}
	
}
