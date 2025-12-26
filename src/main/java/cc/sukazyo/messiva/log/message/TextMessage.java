package cc.sukazyo.messiva.log.message;

import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TextMessage implements IMessage {
	
	@Nonnull String message;
	
	public TextMessage (@Nullable String message) {
		this.message = message == null ? "" : message;
	}
	
	@Override
	public String getText () {
		return message;
	}
	
	@Override
	public String[] getLines () {
		return StringUtils.lines(message);
	}
	
}
