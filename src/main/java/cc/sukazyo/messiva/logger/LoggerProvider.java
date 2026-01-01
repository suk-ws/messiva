package cc.sukazyo.messiva.logger;

import javax.annotation.Nonnull;

public interface LoggerProvider {
	
	@Nonnull Logger getLogger(@Nonnull String name);
	
}
