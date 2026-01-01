package cc.sukazyo.messiva.manager;

import cc.sukazyo.messiva.formatter.ILogFormatter;
import cc.sukazyo.messiva.io.LoggingIOBinder;
import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface LoggingContext {
	
	class Defaults implements LoggingContext {
		@Nonnull ILogFormatter formatter;
		@Nonnull LoggingIOBinder io;
		public Defaults (@Nonnull ILogFormatter formatter, @Nonnull LoggingIOBinder io) {
			this.formatter = formatter;
			this.io = io;
		}
		@Nonnull @Override public LoggingIOBinder getIO() { return io; }
		@Nonnull @Override public ILogFormatter getFormatter() { return formatter; }
	}
	
	static LoggingContext of (@Nonnull ILogFormatter formatter, @Nonnull LoggingIOBinder io) {
		return new Defaults(formatter, io);
	}
	
	@Nonnull LoggingIOBinder getIO();
	
	@Nonnull ILogFormatter getFormatter();
	
	default void put (Log log) {
		getIO().write(
				getFormatter().format(log)
		);
	}
	
}
