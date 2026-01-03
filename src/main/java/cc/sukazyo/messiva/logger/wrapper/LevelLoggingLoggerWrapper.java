package cc.sukazyo.messiva.logger.wrapper;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.level.LogLevels;
import cc.sukazyo.messiva.log.LoggingInternal;
import cc.sukazyo.messiva.log.message.TextMessage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@LoggingInternal
public interface LevelLoggingLoggerWrapper extends LoggerWrapper {
	
	default void trace (@Nullable String message) { self().log(Log.of(LogLevels.TRACE, TextMessage.of(message))); }
	default void debug (@Nullable String message) { self().log(Log.of(LogLevels.DEBUG, TextMessage.of(message))); }
	default void info  (@Nullable String message) { self().log(Log.of(LogLevels.INFO,  TextMessage.of(message))); }
	default void warn  (@Nullable String message) { self().log(Log.of(LogLevels.WARN,  TextMessage.of(message))); }
	default void error (@Nullable String message) { self().log(Log.of(LogLevels.ERROR, TextMessage.of(message))); }
	default void fatal (@Nullable String message) { self().log(Log.of(LogLevels.FATAL, TextMessage.of(message))); }
	
	default void trace (@Nonnull Exception e, @Nullable String message) { self().log(Log.of(LogLevels.TRACE, e, TextMessage.of(message))); }
	default void debug (@Nonnull Exception e, @Nullable String message) { self().log(Log.of(LogLevels.DEBUG, e, TextMessage.of(message))); }
	default void info  (@Nonnull Exception e, @Nullable String message) { self().log(Log.of(LogLevels.INFO,  e, TextMessage.of(message))); }
	default void warn  (@Nonnull Exception e, @Nullable String message) { self().log(Log.of(LogLevels.WARN,  e, TextMessage.of(message))); }
	default void error (@Nonnull Exception e, @Nullable String message) { self().log(Log.of(LogLevels.ERROR, e, TextMessage.of(message))); }
	default void fatal (@Nonnull Exception e, @Nullable String message) { self().log(Log.of(LogLevels.FATAL, e, TextMessage.of(message))); }
	
}
