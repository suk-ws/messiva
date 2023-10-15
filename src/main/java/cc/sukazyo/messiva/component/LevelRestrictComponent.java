package cc.sukazyo.messiva.component;

import cc.sukazyo.messiva.log.ILogLevel;
import cc.sukazyo.messiva.log.LogLevels;

import javax.annotation.Nonnull;

public class LevelRestrictComponent {
	
	@Nonnull private ILogLevel minLevel;
	@Nonnull private ILogLevel maxLevel;
	
	public LevelRestrictComponent (@Nonnull ILogLevel minLevel, @Nonnull ILogLevel maxLevel) {
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
	}
	
	public LevelRestrictComponent (@Nonnull ILogLevel minLevel) {
		this(minLevel, LogLevels.NONE);
	}
	
	public LevelRestrictComponent () {
		this(LogLevels.ALL);
	}
	
	@Nonnull
	public LevelRestrictComponent minLevel (@Nonnull ILogLevel minLevel) {
		this.minLevel = minLevel;
		return this;
	}
	
	@Nonnull
	public LevelRestrictComponent maxLevel (@Nonnull ILogLevel maxLevel) {
		this.maxLevel = maxLevel;
		return this;
	}
	
	@Nonnull
	public ILogLevel minLevel () {
		return this.minLevel;
	}
	
	@Nonnull
	public ILogLevel maxLevel () {
		return this.maxLevel;
	}
	
	public boolean checkLevel (@Nonnull ILogLevel level) {
		return level.level() >= minLevel.level() && level.level() <= maxLevel.level();
	}
	
}
