package cc.sukazyo.messiva.logger;

import javax.annotation.Nonnull;

public interface ILoggerInfo {
	
	/**
	 * Name of this logger.
	 *
	 * <h2>Implementation note</h2>
	 *
	 * <p>
	 *     It must be immutable and must not change for the lifetime of the logger instance,
	 *     due to the sub-loggers may cache its parent logger's name for performance.
	 * </p>
	 */
	@Nonnull String getName();
	
	
	/**
	 * Full name of this logger. Contains all the parents names and its own name.
	 *
	 * <p>
	 *     The root parent name is at first index, and this logger's name is at last index. For
	 *     example, for the loggers below:
	 *     <pre><code>
	 *         Logger root = Manager.getLogger("App");
	 *         Logger someSubsequence = root.getLogger("Subsequence");
	 *         Logger someWorker = someSubsequence.getLogger("Worker");
	 *     </code></pre>
	 *     the full name of the "Worker" logger would be: {@code ["App", "Subsequence", "Worker"]}.
	 * </p>
	 *
	 * <h2>Implementation note</h2>
	 *
	 * <p>
	 *     It must be immutable and must not change for the lifetime of the logger instance,
	 *     due to the sub-loggers may cache its parent logger's name for performance.
	 * </p>
	 */
	@Nonnull String[] getFullName();
	
}
