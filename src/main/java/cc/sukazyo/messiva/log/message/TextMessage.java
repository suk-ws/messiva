package cc.sukazyo.messiva.log.message;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TextMessage implements IMessage {
	
	@Nonnull String message;
	
	public TextMessage (@Nullable String message) {
		this.message = message == null ? "" : message;
	}
	
	@Nonnull
	public static TextMessage of (@Nullable String message) {
		return new TextMessage(message);
	}
	
	@Override
	public String getText () {
		return message;
	}
	
}
