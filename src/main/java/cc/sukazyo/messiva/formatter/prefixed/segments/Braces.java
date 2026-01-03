package cc.sukazyo.messiva.formatter.prefixed.segments;

import javax.annotation.Nonnull;

public class Braces {
	
	public static final Braces Parentheses = Braces.of("(", ")");
	public static final Braces Square      = Braces.of("[", "]");
	public static final Braces Curly       = Braces.of("{", "}");
	public static final Braces Angle       = Braces.of("<", ">");
	public static final Braces Single      = Braces.of("'", "'");
	public static final Braces Double      = Braces.of("\"", "\"");
	public static final Braces Backtick    = Braces.of("`", "`");
	public static final Braces Space       = Braces.of(" ", " ");
	
	@Nonnull private final String left;
	@Nonnull private final String right;
	
	private Braces (@Nonnull String left, @Nonnull String right) {
		this.left = left;
		this.right = right;
	}
	
	@Nonnull
	public static Braces of (@Nonnull String left, @Nonnull String right) {
		return new Braces(left, right);
	}
	
	@Nonnull
	public BracedSegment wrap (@Nonnull Segment segment) {
		return new BracedSegment(left, segment, right);
	}
	
}
