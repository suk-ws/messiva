package cc.sukazyo.messiva.log;

public class Message {
	
	public final String[] message;
	
	public Message(String message) {
		this.message = message == null ? new String[]{} : message.split("\n");
	}
	
}
