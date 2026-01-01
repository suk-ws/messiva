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
	public static PrefixedFormatter with (@Nonnull PrefixSegment[] segments, @Nonnull PrefixSegment[] separator) {
		return BasePrefixedFormatter.with(segments, separator);
	}
	
	@Nonnull
	public static PrefixedFormatter with (@Nonnull PrefixSegment[] segments) {
		// *user defined prefix* | Some messages...
		return BasePrefixedFormatter.with(segments, new PrefixSegment[]{
				PrefixTexts.Space, PrefixTexts.VerticalBar, PrefixTexts.Space
		});
	}
	
	@Nonnull
	public static PrefixedFormatter inDefault () {
		// [1979-01-01T00:00:00.000][messiva-test][main][ERRO] | Some messages...
		// fixme: complete the remaining un-implemented prefixes
		return BasePrefixedFormatter.with(new PrefixSegment[]{
				PrefixBraces.Square.wrap(new TimePrefix()),
				PrefixBraces.Square.wrap(new LoggersPrefix()),
				PrefixBraces.Square.wrap(new ThreadNamePrefix()),
				PrefixBraces.Square.wrap(new StackLocationPrefix()),
				PrefixBraces.Square.wrap(LogLevelPrefix.USE_GLOBAL),
		});
	}
	
	@Nonnull
	protected abstract PrefixSegment[] getPromptPrefixes (@Nonnull Log log);
	
	@Nonnull
	protected abstract PrefixSegment[] getOngoingPrefixes (@Nonnull Log log, @Nonnull String promptPrefix);
	
	@Nonnull
	protected abstract PrefixSegment[] getSeparatorPrefixes (@Nonnull Log log);
	
	@Nonnull
	@Override
	public String format (@Nonnull Log log) {
		final StringBuilder prompt = new StringBuilder();
		final StringBuilder ongoing = new StringBuilder();
		final StringBuilder separator = new StringBuilder();
		for (PrefixSegment segment : getPromptPrefixes(log)) {
			prompt.append(segment.text(log));
		}
		final String promptText = prompt.toString();
		for (PrefixSegment segment : getOngoingPrefixes(log, promptText)) {
			ongoing.append(segment.text(log));
		}
		for (PrefixSegment segment : getSeparatorPrefixes(log)) {
			separator.append(segment.text(log));
		}
		final String ongoingText = ongoing.toString();
		final String separatorText = separator.toString();
		final String[] lines = StringUtils.lines(log.message().getText());
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < lines.length; i++) {
			if (i == 0) {
				result.append(promptText).append(separatorText).append(lines[i]);
			} else {
				result.append('\n').append(ongoingText).append(separatorText).append(lines[i]);
			}
		}
		return result.append('\n').toString();
	}
	
}
