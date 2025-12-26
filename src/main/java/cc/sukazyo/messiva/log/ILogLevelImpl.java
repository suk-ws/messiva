package cc.sukazyo.messiva.log;

import cc.sukazyo.messiva.log.message.IMessage;

import javax.annotation.Nonnull;

@Deprecated
public interface ILogLevelImpl {
	
	void trace (@Nonnull String message);
	
	void debug (@Nonnull String message);
	
	void info (@Nonnull String message);
	
	void warn (@Nonnull String message);
	
	void warning (@Nonnull String message);
	
	void error (@Nonnull String message);
	
	void fatal (@Nonnull String message);
	
	void trace (@Nonnull IMessage message);
	
	void debug (@Nonnull IMessage message);
	
	void info (@Nonnull IMessage message);
	
	void warn (@Nonnull IMessage message);
	
	void warning (@Nonnull IMessage message);
	
	void error (@Nonnull IMessage message);
	
	void fatal (@Nonnull IMessage message);
	
}
