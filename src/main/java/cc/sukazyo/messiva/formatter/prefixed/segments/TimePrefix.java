package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class TimePrefix implements PrefixSegment {
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return String.valueOf(log.timestamp());
	}
	
}
