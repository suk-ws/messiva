package cc.sukazyo.messiva.appender;

import cc.sukazyo.messiva.formatter.ILogFormatter;
import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.locks.ReentrantLock;

public class ConsoleAppender extends AppenderRestrictableByLevel {
	
	@Nonnull private final ReentrantLock syncLock;
	
	public ConsoleAppender (@Nullable ILogFormatter formatter) {
		super(formatter);
		syncLock = new ReentrantLock();
	}
	
	public ConsoleAppender () {
		this(null);
	}
	
	@Override
	public void pushLogChecked (@Nonnull Log log) {
		if (formatter == null) return;
		syncLock.lock();
		System.out.println(formatter.format(log));
		syncLock.unlock();
	}
	
}
