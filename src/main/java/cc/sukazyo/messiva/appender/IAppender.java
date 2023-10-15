package cc.sukazyo.messiva.appender;

import javax.annotation.Nonnull;

import cc.sukazyo.messiva.log.Log;

public interface IAppender {
	
	void pushLog (@Nonnull Log log);
	
}
