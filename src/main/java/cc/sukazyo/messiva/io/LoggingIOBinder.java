package cc.sukazyo.messiva.io;

/**
 * IO interface for logging messages.
 *
 * <p>
 *     Every messages that send to this binder should and can not be changed.
 *     Messages may or may not send to here per line.
 * </p>
 */
public interface LoggingIOBinder {
	
	void write (String message);
	
}
