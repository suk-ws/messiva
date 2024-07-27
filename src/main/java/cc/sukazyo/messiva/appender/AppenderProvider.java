package cc.sukazyo.messiva.appender;

import cc.sukazyo.std.contexts.GivenContext;

import javax.annotation.Nonnull;
import java.util.List;

public interface AppenderProvider {
	
	@Nonnull
	List<IAppender> findAppends (@Nonnull GivenContext context);
	
}
