package cc.sukazyo.messiva.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as internal class of logging system.
 *
 * <h2>Purpose</h2>
 *
 * <p>
 *     In some cases, a {@link Log} may created inside a logger helper, but Log's
 *     {@link Log#stackTrace()} can only record where the Log is created (if no external stack
 *     trace is passed to constructor).
 * </p>
 *
 * <blockquote>
 *     For example, if logger is directly created by app:
 *     <pre><code>
 *         logger.log(new Log(LogLevels.INFO, TextMessage.of("Hello World!")))
 *     </code></pre>
 *     then the {@link Log}'s constructor can get the app's stack trace easily (by just getting
 *     the current stack trace and trim the top frames inside).
 *     <p>
 *         But this is way more complicated for apps. In most cases, the real code is like this:
 *         <pre><code>
 *             // Logger.java
 *             public void info (String str) {
 *                 this.log(new Log(LogLevels.INFO, TextMessage.of(str)));
 *             }
 *             // App.java
 *             logger.info("Hello World!");
 *         </code></pre>
 *         It is very good for app developers! But for the {@link Log}'s constructor that
 *         described above, it will get a stack trace where the top frame is {@code Log#info}.
 *         This is not what the app wants!
 *     </p>
 *     <p>
 *         And this problem can be even worse. Consider if the app creates its own log levels,
 *         and create a Logger wrapper for convenience uses the custom log levels:
 *         <pre><code>
 *             // CustomLogLevels.java
 *             public class CustomLogLevels {
 *                 public static final ILogLevel ALERT = LogLevels.of("ALERT", 350);
 *             }
 *             // CustomLogger.java
 *             private final Logger logger;
 *             public void alert (String str) {
 *                 this.logger.log(new Log(CustomLogLevels.ALERT, TextMessage.of(str)));
 *             }
 *             public void info (String str) {
 *                 logger.info(str);
 *             }
 *             // App.java
 *             customLogger.alert("This is an alert!");
 *             customLogger.info("This is just info.");
 *         </code></pre>
 *         Now, the {@link Log} will record a stack trace that is [CustomLogger#alert, App#main]
 *         for alert logs, and [Logger#info, App#main] for info logs. The garbage frames that
 *         we do not want even has different lengths!
 *     </p>
 *     <p>
 *         If some compile time optimization is applied (like inlining methods in scala), the
 *         problem will just get worse, as the developer have no idea about how many frames are
 *         inlined away and how many length of frames we do not want.
 *     </p>
 * </blockquote>
 *
 * <p>
 *     To avoid the above problem, this annotation is created. By marking a class with this
 *     annotation, the {@link Log#stackTrace()} method can have enough information to trim the
 *     helper classes, thus showing the real application code that created the Log.
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LoggingInternal { }
