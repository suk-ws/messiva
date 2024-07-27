package cc.sukazyo.messiva.appender;

import cc.sukazyo.std.contexts.GivenContext;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class StaticAppenderProvider implements AppenderProvider {
	
	@Nonnull final IAppender appender;
	
	public StaticAppenderProvider (@Nonnull IAppender appender) {
		this.appender = appender;
	}
	
	@Nonnull
	@Override
	public List<IAppender> findAppends (@Nonnull GivenContext context) {
		return Collections.singletonList(appender);
	}
	
}
