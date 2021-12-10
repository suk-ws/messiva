package cc.sukazyo.messiva;

import cc.sukazyo.messiva.appender.IAppender;
import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.LogLevel;
import cc.sukazyo.messiva.log.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logger {
	
	public final List<IAppender> appends = new ArrayList<>();
	
	public Logger () {}
	
	public Logger (IAppender... appends) {
		this.appends.addAll(Arrays.asList(appends));
	}
	
	public void trace (String message) {
		pushToAllAppender(new Log(1, new Message(message), LogLevel.TRACE));
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
	
	private void pushToAllAppender (Log log) {
		for (IAppender appender : appends) {
			appender.pushLog(log);
		}
	}
	
}
