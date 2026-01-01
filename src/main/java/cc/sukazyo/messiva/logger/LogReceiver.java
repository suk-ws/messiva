package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public interface LogReceiver {
	
	void receiveLog (@Nonnull Log log);
	
}
