package cc.sukazyo.messiva.log;

public interface ILogLevelImpl {
	
	void trace (String message);
	
	void debug (String message);
	
	void info (String message);
	
	void warn (String message);
	
	void warning (String message);
	
	void error (String message);
	
	void fatal (String message);
	
	void trace (Message message);
	
	void debug (Message message);
	
	void info (Message message);
	
	void warn (Message message);
	
	void warning (Message message);
	
	void error (Message message);
	
	void fatal (Message message);
	
}
