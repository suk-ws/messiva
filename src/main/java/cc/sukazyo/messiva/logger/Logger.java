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
	
	public Logger (@Nonnull IAppender... appends) {
		this();
		this.appends.addAll(Arrays.asList(appends));
	}
	
	@Nonnull
	public Logger minLevel (@Nonnull ILogLevel minLevel) {
		levelSetting.minLevel(minLevel);
		return this;
	}
	
	@Nonnull
	public Logger maxLevel (@Nonnull ILogLevel maxLevel) {
		levelSetting.maxLevel(maxLevel);
		return this;
	}
	
	public void trace (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.TRACE));
	}
	
	public void debug (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.DEBUG));
	}
	
	public void info (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.INFO));
	}
	
	public void warn (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.WARN));
	}
	
	public void warning (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.WARN));
	}
	
	public void error (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.ERROR));
	}
	
	public void fatal (@Nonnull String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevels.FATAL));
	}
	
	public void trace (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.TRACE));
	}
	
	public void debug (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.DEBUG));
	}
	
	public void info (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.INFO));
	}
	
	public void warn (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.WARN));
	}
	
	public void warning (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.WARN));
	}
	
	public void error (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.ERROR));
	}
	
	public void fatal (@Nonnull Message message) {
		pushToAllAppender(new Log(1, message, LogLevels.FATAL));
	}
	
	public void log (@Nonnull String message, @Nonnull ILogLevel level) {
		pushToAllAppender(new Log(1, new Message(message), level));
	}
	
	public void log (@Nonnull Message message, @Nonnull ILogLevel level) {
		pushToAllAppender(new Log(1, message, level));
	}
	
	protected void pushToAllAppender (@Nonnull Log log) {
		if (!levelSetting.checkLevel(log.level)) return;
		for (IAppender appender : appends) {
			appender.pushLog(log);
		}
	}
	
}
