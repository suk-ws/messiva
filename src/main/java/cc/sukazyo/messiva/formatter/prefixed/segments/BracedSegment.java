package cc.sukazyo.messiva.formatter.prefixed.segments;

import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;

public class BracedSegment implements Segment {
	
	@Nonnull private final Segment segment;
	@Nonnull private final String left;
	@Nonnull private final String right;
	
	public BracedSegment (@Nonnull String left, @Nonnull Segment segment, @Nonnull String right) {
		this.segment = segment;
		this.left = left;
		this.right = right;
	}
	
	@Nonnull
	@Override
	public String text (@Nonnull Log log) {
		return this.left + segment.text(log) + this.right;
	}
	
}
