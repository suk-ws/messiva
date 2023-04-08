package cc.sukazyo.messiva.component;

import cc.sukazyo.messiva.log.LogLevel;

import javax.annotation.Nonnull;

public class LevelRestrictComponent {
	
	@Nonnull private LogLevel minLevel;
	@Nonnull private LogLevel maxLevel;
	
	public LevelRestrictComponent (@Nonnull LogLevel minLevel, @Nonnull LogLevel maxLevel) {
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
	}
	
	public LevelRestrictComponent (@Nonnull LogLevel minLevel) {
		this(minLevel, LogLevel.NONE);
	}
	
	public LevelRestrictComponent () {
		this(LogLevel.ALL);
	}
	
	@Nonnull
	public LevelRestrictComponent minLevel (@Nonnull LogLevel minLevel) {
		this.minLevel = minLevel;
		return this;
	}
	
	@Nonnull
	public LevelRestrictComponent maxLevel (@Nonnull LogLevel maxLevel) {
		this.maxLevel = maxLevel;
		return this;
	}
	
	@Nonnull
	public LogLevel minLevel () {
		return this.minLevel;
	}
	
	@Nonnull
	public LogLevel maxLevel () {
		return this.maxLevel;
	}
	
	public boolean checkLevel (@Nonnull LogLevel level) {
		return level.level >= minLevel.level && level.level <= maxLevel.level;
	}
	
}
