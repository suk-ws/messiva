package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class PrefixTexts implements PrefixSegment {
	
	public static final PrefixTexts VerticalBar = new PrefixTexts("|");
	public static final PrefixTexts Space = new PrefixTexts(" ");
	
	private final String text;
	
	public PrefixTexts (@Nonnull String text) {
		this.text = text;
	}
	
	@Override
	@Nonnull
	public String text (@Nonnull Log log) {
		return text;
	}
	
	@Nonnull
	public PrefixTexts repeat (@Nonnegative int len) {
		return new PrefixTexts(StringUtils.repeat(this.text, len));
	}
	
}
