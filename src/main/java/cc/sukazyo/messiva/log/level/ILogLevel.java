package cc.sukazyo.messiva.log.level;

import javax.annotation.Nonnull;

public interface ILogLevel {
	float level();
	@Nonnull String id();
}
