package cc.sukazyo.messiva.log;

public interface ILogLevelImpl {
	
	void trace (String message);
	
	void debug (String message);
	
	void info (String message);
	
	void warn (String message);
	
	void error (String message);
	
	void fatal (String message);
	
}
