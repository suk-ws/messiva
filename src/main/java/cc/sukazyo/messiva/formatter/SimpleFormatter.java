package cc.sukazyo.messiva.formatter;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnull;

public class SimpleFormatter implements ILogFormatter {
	
	@Nonnull public String startTimestamp = "[";
	@Nonnull public String endTimestamp = "]";
	@Nonnull public String startThreadName = "[";
	@Nonnull public String endThreadName = "]";
	@Nonnull public String startLevelTag = "[";
	@Nonnull public String endLevelTag = "]";
	public char followingLineFillChar = '\'';
	
	@Nonnull
	@Override
	public String format (@Nonnull Log log) {
		final StringBuilder message = new StringBuilder();
		message.append(startTimestamp).append(log.timestamp).append(endTimestamp)
				.append(startThreadName).append(log.thread.getName()).append(endThreadName);
		final String promptNewline = StringUtils.repeatChar(followingLineFillChar, message.length());
		message.append(startLevelTag).append(log.level.tag()).append(endLevelTag).append(log.message.message[0]);
		for (int i = 1; i < log.message.message.length; i++) {
			message.append('\n').append(promptNewline)
					.append(startLevelTag).append(log.level.tag()).append(endLevelTag).append(log.message.message[i]);
		}
		return message.toString();
	}
	
}
