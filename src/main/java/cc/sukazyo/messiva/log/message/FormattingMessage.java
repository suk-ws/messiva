package cc.sukazyo.messiva.log.message;

import java.util.IllegalFormatException;

public class FormattingMessage implements IMessage {
	
	private final String template;
	private final Object[] params;
	
	public FormattingMessage (String template, Object... params) {
		this.template = template;
		this.params = params;
	}
	
	@Override
	public String getText () throws IllegalFormatException {
		return String.format(template, params);
	}
	
}
