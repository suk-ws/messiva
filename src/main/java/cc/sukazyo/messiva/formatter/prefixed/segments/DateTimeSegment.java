package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

// fixme: timezone is cached or pre-loaded, does this fails on some daylight saving time changes?
public class DateTimeSegment implements Segment {
	
	private static final DateTimeFormatter _PATTERN_NORMAL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final DateTimeFormatter _PATTERN_NORMAL_MILLIS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static final DateTimeSegment ISO = DateTimeSegment.with(DateTimeFormatter.ISO_DATE_TIME);
	public static final DateTimeSegment LOCAL_ISO = DateTimeSegment.withSystemTimeZone(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	public static final DateTimeSegment LOCAL_ISO_ZONED = DateTimeSegment.withSystemTimeZone(DateTimeFormatter.ISO_DATE_TIME);
	public static final DateTimeSegment RFC = DateTimeSegment.with(DateTimeFormatter.RFC_1123_DATE_TIME);
	public static final DateTimeSegment LOCAL_RFC = DateTimeSegment.withSystemTimeZone(DateTimeFormatter.RFC_1123_DATE_TIME);
	public static final DateTimeSegment NORMAL = DateTimeSegment.with(_PATTERN_NORMAL);
	public static final DateTimeSegment LOCAL_NORMAL = DateTimeSegment.withSystemTimeZone(_PATTERN_NORMAL);
	public static final DateTimeSegment NORMAL_MILLIS = DateTimeSegment.with(_PATTERN_NORMAL_MILLIS);
	public static final DateTimeSegment LOCAL_NORMAL_MILLIS = DateTimeSegment.withSystemTimeZone(_PATTERN_NORMAL_MILLIS);
	
	@Nonnull
	private final DateTimeFormatter format;
	@Nonnull
	private final ZoneOffset timeZone;
	
	private DateTimeSegment (@Nonnull DateTimeFormatter format, @Nonnull ZoneOffset timeZone) {
		this.format = format;
		this.timeZone = timeZone;
	}
	
	@Nonnull
	public static DateTimeSegment with (@Nonnull DateTimeFormatter format, @Nonnull ZoneOffset timeZone) {
		return new DateTimeSegment(format, timeZone);
	}
	
	@Nonnull
	public static DateTimeSegment with (@Nonnull String template) {
		return new DateTimeSegment(DateTimeFormatter.ofPattern(template), ZoneOffset.UTC);
	}
	
	@Nonnull
	public static DateTimeSegment with (@Nonnull DateTimeFormatter format) {
		return new DateTimeSegment(format, ZoneOffset.UTC);
	}
	
	@Nonnull
	public static DateTimeSegment withSystemTimeZone (@Nonnull DateTimeFormatter format) {
		return new DateTimeSegment(format, ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
	}
	
	@Nonnull
	public static DateTimeSegment withSystemTimeZone (@Nonnull String template) {
		return new DateTimeSegment(DateTimeFormatter.ofPattern(template), ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
	}
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		final Instant time = Instant.ofEpochMilli(log.timestamp());
		return format.format(time.atZone(timeZone));
	}
	
}
