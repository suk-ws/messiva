package cc.sukazyo.messiva.formatter;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.log.LogLevelNameMapper;
import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnull;

public class SimpleFormatter implements ILogFormatter {
	
	@Nonnull public String startTimestamp = "[";
	@Nonnull public String endTimestamp = "]";
	
	@Nonnull public String startThreadName = "[";
	@Nonnull public String endThreadName = "]";
	
	@Nonnull public String startCodePoint = "[";
	@Nonnull public String endCodePoint = "]";
	
	@Nonnull public String startLevelTag = "[";
	@Nonnull public String endLevelTag = "]";
	
	public char followingLineFillChar = '\'';
	
	@Nonnull public String messageSeparator = " ";
	
	@Nonnull
	@Override
	public String format (@Nonnull Log log) {
		
		final StringBuilder message = new StringBuilder();
		
		final String[] text = StringUtils.lines(log.message().getText());
		
		final String formattedTime = startTimestamp + this.formatTimestamp(log) + endTimestamp;
		final String formattedThread = startThreadName + log.thread().getName() + endThreadName;
		final String formattedCodePoint = startCodePoint + this.formatCodepoint(log) + endCodePoint;
		final String formattedLevel = startLevelTag + LogLevelNameMapper.GLOBAL.getName(log.level()) + endLevelTag;
		
		final String formattedPromptOnlyNewline = formattedTime + formattedCodePoint + formattedThread;
		final String formattedPrompt = formattedPromptOnlyNewline + formattedLevel;
		final String formattedPromptFollowing = StringUtils.repeatChar(followingLineFillChar, formattedPromptOnlyNewline.length()) + formattedLevel;
		
		message.append(formattedPrompt)
				.append(messageSeparator).append(text[0]);
		for (int i = 1; i < text.length; i++) {
			message.append('\n').append(formattedPromptFollowing)
					.append(messageSeparator).append(text[i]);
		}
		
		return message.toString();
		
	}
	
	@Nonnull
	protected String formatTimestamp (@Nonnull Log log) {
		return String.valueOf(log.timestamp());
	}
	
	@Nonnull
	protected String formatCodepoint (@Nonnull Log log) {
		return log.stackTrace()[0].getClassName() + "#" + log.stackTrace()[0].getMethodName();
	}
	
}
