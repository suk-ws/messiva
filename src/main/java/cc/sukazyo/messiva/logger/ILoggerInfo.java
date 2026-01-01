package cc.sukazyo.messiva.logger;

import javax.annotation.Nonnull;

public interface ILoggerInfo {
	
	@Nonnull String getName();
	
	@Nonnull String[] getFullName();
	
}
