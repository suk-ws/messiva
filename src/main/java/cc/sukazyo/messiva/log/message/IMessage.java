package cc.sukazyo.messiva.log.message;

public interface IMessage {
	
	String getText ();
	
	@Deprecated
	String[] getLines ();
	
}
