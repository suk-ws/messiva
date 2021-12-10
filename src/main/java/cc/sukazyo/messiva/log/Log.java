package cc.sukazyo.messiva.log;

import cc.sukazyo.messiva.utils.StackUtils;

public class Log {
	
	public final Message message;
	public final LogLevel level;
	public final long timestamp;
	public final Thread thread;
	public final StackTraceElement[] stackTrace;
	
	public Log (Message message, LogLevel level, Thread thread, long timestamp, StackTraceElement[] stackTrace) {
		this.message = message;
		this.level = level;
		this.thread = thread;
		this.timestamp = timestamp;
		this.stackTrace = stackTrace;
	}
	
	public Log (int stackOffset, Message message, LogLevel level, Thread thread, long timestamp) {
		this(message, level, thread, timestamp, StackUtils.getStackTrace(stackOffset+1));
	}
	
	public Log (Message message, LogLevel level, Thread thread, long timestamp) {
		this(1, message, level, thread, timestamp);
	}
	
	public Log (int stackOffset, Message message, LogLevel level, Thread thread) {
		this(stackOffset+1, message, level, thread, System.currentTimeMillis());
	}
	
	public Log (Message message, LogLevel level, Thread thread) {
		this(1, message, level, thread);
	}
	
	public Log (int stackOffset, Message message, LogLevel level) {
		this(stackOffset+1, message, level, Thread.currentThread());
	}
	
	public Log (Message message, LogLevel level) {
		this(1, message, level);
	}
	
}
