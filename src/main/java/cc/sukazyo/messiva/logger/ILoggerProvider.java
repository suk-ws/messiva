package cc.sukazyo.messiva.logger;

import javax.annotation.Nonnull;

public interface ILoggerProvider {
	
	@Nonnull Logger getLogger(@Nonnull String name);
	
}
