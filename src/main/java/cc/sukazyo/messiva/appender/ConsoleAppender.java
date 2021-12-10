package cc.sukazyo.messiva.appender;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.utils.StringUtils;

import java.util.concurrent.locks.ReentrantLock;

public class ConsoleAppender implements IAppender {
	
	private final ReentrantLock syncLock = new ReentrantLock();
	
//	private final AppendDaemon DAEMON;
//	private static class AppendDaemon extends Thread {
//		public AppendDaemon () { this.setName("console-appender-daemon::" + UUID.randomUUID()); }
//		@Override public void run () {
//
//		}
//	}
//
	public ConsoleAppender() {
//		DAEMON = new AppendDaemon();
//		DAEMON.start();
	}
	
	@Override
	public void pushLog (Log log) {
		syncLock.lock();
		System.out.println(formatMessage(log));
		syncLock.unlock();
	}
	
	private static String formatMessage (Log log) {
		final StringBuilder message = new StringBuilder();
		message.append('[').append(log.timestamp)
				.append("][").append(log.thread.getName())
				.append("]");
		final String promptNewline = StringUtils.repeatChar('\'', message.length());
		message.append('[').append(log.level.tag).append(']').append(log.message.message[0]);
		for (int i = 1; i < log.message.message.length; i++) {
			message.append('\n').append(promptNewline)
					.append('[').append(log.level.tag).append(']').append(log.message.message[i]);
		}
		return message.toString();
	}
	
}
