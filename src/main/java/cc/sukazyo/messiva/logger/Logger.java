package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.component.LevelRestrictComponent;
import cc.sukazyo.messiva.appender.IAppender;
import cc.sukazyo.messiva.log.ILogLevelImpl;
import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.LogLevel;
import cc.sukazyo.messiva.log.Message;

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
	
	public Logger minLevel (@Nonnull LogLevel minLevel) {
		levelSetting.minLevel(minLevel);
		return this;
	}
	
	public Logger maxLevel (@Nonnull LogLevel maxLevel) {
		levelSetting.maxLevel(maxLevel);
		return this;
	}
	
	public void trace (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.TRACE));
	}
	
	public void debug (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.DEBUG));
	}
	
	public void info (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.INFO));
	}
	
	public void warn (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.WARN));
	}
	
	public void warning (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.WARN));
	}
	
	public void error (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.ERROR));
	}
	
	public void fatal (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.FATAL));
	}
	
	private void pushToAllAppender (@Nonnull Log log) {
		if (!levelSetting.checkLevel(log.level)) return;
		for (IAppender appender : appends) {
			appender.pushLog(log);
		}
	}
	
}
