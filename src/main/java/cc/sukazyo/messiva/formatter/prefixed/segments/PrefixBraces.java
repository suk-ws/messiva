package cc.sukazyo.messiva.formatter.prefixed.segments;

import javax.annotation.Nonnull;

public class PrefixBraces {
	
	public static final PrefixBraces Parentheses = new PrefixBraces("(", ")");
	public static final PrefixBraces Square      = new PrefixBraces("[", "]");
	public static final PrefixBraces Curly       = new PrefixBraces("{", "}");
	public static final PrefixBraces Angle       = new PrefixBraces("<", ">");
	public static final PrefixBraces Single      = new PrefixBraces("'", "'");
	public static final PrefixBraces Double      = new PrefixBraces("\"", "\"");
	
	@Nonnull private final String left;
	@Nonnull private final String right;
	
	public PrefixBraces (@Nonnull String left, @Nonnull String right) {
		this.left = left;
		this.right = right;
	}
	
	@Nonnull
	public BracedPrefix wrap (@Nonnull PrefixSegment segment) {
		return new BracedPrefix(left, segment, right);
	}
	
}
