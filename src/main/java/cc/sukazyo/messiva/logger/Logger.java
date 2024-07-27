package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.appender.AppenderProvider;
import cc.sukazyo.messiva.component.LevelRestrictComponent;
import cc.sukazyo.messiva.appender.IAppender;
import cc.sukazyo.messiva.log.*;
import cc.sukazyo.messiva.log.message.IMessage;
import cc.sukazyo.messiva.log.message.TextMessage;
import cc.sukazyo.std.contexts.GivenContext;
import cc.sukazyo.std.stacks.WithCurrentStack;
import scala.reflect.ClassTag;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Logger implements ILogLevelImpl {
	
	/**
	 * @deprecated API changes. use {@link #appenderProviders} instead. This field will always
	 *             be empty.
	 */
	@Deprecated
	@Nonnull public final List<IAppender> appends = Collections.emptyList();
	
	@Nonnull public final String name;
	@Nonnull public final List<AppenderProvider> appenderProviders;
	
	@Nonnull public LevelRestrictComponent levelSetting;
	
	public Logger () {
		levelSetting = new LevelRestrictComponent();
		appenderProviders = new ArrayList<>();
		this.name = WithCurrentStack.getStackTrace(1)[0].getClass().getSimpleName();
	}
	
	public Logger (@Nonnull IAppender... appends) {
		this();
		this.appenderProviders.addAll(
				Arrays.stream(appends)
					  .map(IAppender::asProvider)
					  .collect(Collectors.toList())
		);
	}
	
	@Nonnull
	public Logger minLevel (@Nonnull ILogLevel minLevel) {
		levelSetting.minLevel(minLevel);
		return this;
	}
	
	@Nonnull
	public Logger maxLevel (@Nonnull ILogLevel maxLevel) {
		levelSetting.maxLevel(maxLevel);
		return this;
	}
	
	public void trace (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.TRACE));
	}
	
	public void debug (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.DEBUG));
	}
	
	public void info (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.INFO));
	}
	
	public void warn (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.WARN));
	}
	
	public void warning (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.WARN));
	}
	
	public void error (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.ERROR));
	}
	
	public void fatal (@Nonnull String message) {
		pushToAllAppender(createNewLog(new TextMessage(message), LogLevels.FATAL));
	}
	
	public void trace (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.TRACE));
	}
	
	public void debug (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.DEBUG));
	}
	
	public void info (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.INFO));
	}
	
	public void warn (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.WARN));
	}
	
	public void warning (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.WARN));
	}
	
	public void error (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.ERROR));
	}
	
	public void fatal (@Nonnull IMessage message) {
		pushToAllAppender(createNewLog(message, LogLevels.FATAL));
	}
	
	public void log (@Nonnull String message, @Nonnull ILogLevel level) {
		pushToAllAppender(createNewLog(new TextMessage(message), level));
	}
	
	public void log (@Nonnull IMessage message, @Nonnull ILogLevel level) {
		pushToAllAppender(createNewLog(message, level));
	}
	
	protected Log createNewLog (@Nonnull IMessage message, ILogLevel level) {
		return new Log(message, level)
				.withContext(cxt -> cxt.ownedBy(Log.Initializing.class).getUnsafe(Log.StackOffset.class).value+=2);
	}
	
	protected void pushToAllAppender (@Nonnull Log log) {
		if (!levelSetting.checkLevel(log.level())) return;
		this.findAppends(log)
			.forEach(appender -> appender.pushLog(log));
	}
	
	protected List<IAppender> findAppends (@Nonnull Log log) {
		final GivenContext context = GivenContext.apply();
		context.provide(this, ClassTag.apply(AppenderProvider.class));
		context.provide(log, ClassTag.apply(Log.class));
		return this.appenderProviders.stream()
				.flatMap(provider -> provider.findAppends(context).stream())
				.collect(Collectors.toList());
	}
	
}
