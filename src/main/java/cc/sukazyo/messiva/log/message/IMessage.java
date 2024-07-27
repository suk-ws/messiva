package cc.sukazyo.messiva.log.message;

import java.util.Arrays;

public interface IMessage {
	
	default String getText () {
		return Arrays.stream(getLines())
					 .reduce((a, b) -> a + "\n" + b)
					 .orElse("");
	}
	
	String[] getLines ();
	
}
