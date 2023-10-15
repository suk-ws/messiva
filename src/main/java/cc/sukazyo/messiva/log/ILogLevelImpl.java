package cc.sukazyo.messiva.log;

import javax.annotation.Nonnull;

public interface ILogLevelImpl {
	
	void trace (@Nonnull String message);
	
	void debug (@Nonnull String message);
	
	void info (@Nonnull String message);
	
	void warn (@Nonnull String message);
	
	void warning (@Nonnull String message);
	
	void error (@Nonnull String message);
	
	void fatal (@Nonnull String message);
	
	void trace (@Nonnull Message message);
	
	void debug (@Nonnull Message message);
	
	void info (@Nonnull Message message);
	
	void warn (@Nonnull Message message);
	
	void warning (@Nonnull Message message);
	
	void error (@Nonnull Message message);
	
	void fatal (@Nonnull Message message);
	
}
