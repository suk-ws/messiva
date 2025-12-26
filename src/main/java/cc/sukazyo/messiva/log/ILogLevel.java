package cc.sukazyo.messiva.log;

import javax.annotation.Nonnull;

public interface ILogLevel {
	float level();
	@Nonnull String id();
	@Deprecated @Nonnull String tag();
}
