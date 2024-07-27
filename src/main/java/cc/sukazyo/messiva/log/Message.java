package cc.sukazyo.messiva.log;

import cc.sukazyo.messiva.log.message.TextMessage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @deprecated API changed. Use {@link cc.sukazyo.messiva.log.message.IMessage} or {@link TextMessage}
 *             instead.
 */
@Deprecated
public class Message extends TextMessage {
	
	/**
	 * Due to API changes, this field is no longer used and will always be empty.
	 */
	@Nonnull
	@Deprecated
	public final String[] message = new String[]{};
	
	public Message(@Nullable String message) {
		super(message);
	}
	
}
