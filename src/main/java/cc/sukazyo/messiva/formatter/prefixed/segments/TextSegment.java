package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class TextSegment implements Segment {
	
	public static final TextSegment VerticalBar = new TextSegment("|");
	public static final TextSegment Space = new TextSegment(" ");
	
	public final String text;
	
	public TextSegment (@Nonnull String text) {
		this.text = text;
	}
	
	@Nonnull
	public static TextSegment of (@Nonnull String text) {
		return new TextSegment(text);
	}
	
	@Override
	@Nonnull
	public String text (@Nonnull Log log) {
		return text;
	}
	
	@Nonnull
	public TextSegment repeat (@Nonnegative int len) {
		return new TextSegment(StringUtils.repeat(this.text, len));
	}
	
}
