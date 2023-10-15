package cc.sukazyo.messiva.log;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Message {
	
	@Nonnull
	public final String[] message;
	
	public Message(@Nullable String message) {
		this.message = message == null ? new String[]{} : message.split("\n");
	}
	
}
