package cc.sukazyo.messiva.formatter.prefixed;

import cc.sukazyo.messiva.formatter.ILogFormatter;
import cc.sukazyo.messiva.formatter.prefixed.segments.*;
import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.utils.StringUtils;

import javax.annotation.Nonnull;

/**
 * <h2>Note</h2>
 * <p>
 *     The old versions default format:
 *     <pre><code>
 *         [1767106636973][main][LogApp#tryFn][INFO] Following is test messages.
 *         [1767106636982][main][LogApp#tryFn][DBUG] This is a multiline test message,
 *         '''''''''''''''''''''''''''''''''''[DBUG]  - it is multiline!
 *         '''''''''''''''''''''''''''''''''''[DBUG]  - it is debug level!
 *     </code></pre>
 * </p>
 */
public abstract class PrefixedFormatter implements ILogFormatter {
	
	@Nonnull
	protected abstract Segment[] getPrefixes (@Nonnull Log log);
	
	@Nonnull
	protected Segment[] getOngoingPrefixes (@Nonnull Log log, @Nonnull String previous) {
		return getPrefixes(log);
	}
	
	@Nonnull
	protected abstract Segment[] getSeparator (@Nonnull Log log);
	
	@Nonnull
	protected Segment[] getOngoingSeparator (@Nonnull Log log, @Nonnull String previous) {
		return getSeparator(log);
	}
	
	@Nonnull
	@Override
	public String format (@Nonnull Log log) {
		final StringBuilder sbPrefix = new StringBuilder();
		final StringBuilder sbOngoingPrefix = new StringBuilder();
		final StringBuilder sbSeparator = new StringBuilder();
		final StringBuilder sbOngoingSeparator = new StringBuilder();
		for (Segment segment : getPrefixes(log)) {
			sbPrefix.append(segment.text(log));
		}
		final String prefix = sbPrefix.toString();
		for (Segment segment : getOngoingPrefixes(log, prefix)) {
			sbOngoingPrefix.append(segment.text(log));
		}
		final String ongoingPrefix = sbOngoingPrefix.toString();
		for (Segment segment : getSeparator(log)) {
			sbSeparator.append(segment.text(log));
		}
		final String separator = sbSeparator.toString();
		for (Segment segment : getOngoingSeparator(log, separator)) {
			sbOngoingSeparator.append(segment.text(log));
		}
		final String ongoingSeparator = sbOngoingSeparator.toString();
		final String[] lines = StringUtils.lines(log.messageAndException());
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < lines.length; i++) {
			if (i == 0) {
				result.append(prefix).append(separator).append(lines[i]);
			} else {
				result.append('\n').append(ongoingPrefix).append(ongoingSeparator).append(lines[i]);
			}
		}
		return result.append('\n').toString();
	}
	
}
