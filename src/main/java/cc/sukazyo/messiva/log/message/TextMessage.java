package cc.sukazyo.messiva.log.message;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TextMessage implements IMessage {
	
	@Nonnull String[] message;
	
	public TextMessage (@Nullable String message) {
		this.message = message != null ? message.split("\\n") : new String[]{};
	}
	
	public TextMessage (@Nonnull String[] messageLines) {
		this.message = messageLines;
	}
	
	@Override
	public String[] getLines () {
		return message;
	}
	
}
