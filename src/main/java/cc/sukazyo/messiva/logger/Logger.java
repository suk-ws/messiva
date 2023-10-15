package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.component.LevelRestrictComponent;
import cc.sukazyo.messiva.appender.IAppender;
import cc.sukazyo.messiva.log.*;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logger implements ILogLevelImpl {
	
	@Nonnull public final List<IAppender> appends;
	
	@Nonnull public LevelRestrictComponent levelSetting;
	
	public Logger () {
		levelSetting = new LevelRestrictComponent();
		appends = new ArrayList<>();
	}
	
	public Logger (IAppender... appends) {
		this();
		this.appends.addAll(Arrays.asList(appends));
	}
	
	public Logger minLevel (@Nonnull ILogLevel minLevel) {
		levelSetting.minLevel(minLevel);
		return this;
	}
	
	public Logger maxLevel (@Nonnull ILogLevel maxLevel) {
		levelSetting.maxLevel(maxLevel);
		return this;
	}
	
	public void trace (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.TRACE));
	}
	
	public void debug (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.DEBUG));
	}
	
	public void info (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.INFO));
	}
	
	public void warn (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.WARN));
	}
	
	public void warning (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.WARN));
	}
	
	public void error (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.ERROR));
	}
	
	public void fatal (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.FATAL));
	}
	
	public void trace (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.TRACE));
	}
	
	public void debug (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.DEBUG));
	}
	
	public void info (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.INFO));
	}
	
	public void warn (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.WARN));
	}
	
	public void warning (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.WARN));
	}
	
	public void error (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.ERROR));
	}
	
	public void fatal (Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.FATAL));
	}
	
	public void log (String message, ILogLevel level) {
		pushToAllAppender(new Log(1, new Message(message), level));
	}
	
	public void log (Message message, ILogLevel level) {
		pushToAllAppender(new Log(1, message, level));
	}
	
	protected void pushToAllAppender (@Nonnull Log log) {
		if (!levelSetting.checkLevel(log.level)) return;
		for (IAppender appender : appends) {
			appender.pushLog(log);
		}
	}
	
}
