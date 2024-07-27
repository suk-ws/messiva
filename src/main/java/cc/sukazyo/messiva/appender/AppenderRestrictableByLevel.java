package cc.sukazyo.messiva.appender;

import cc.sukazyo.messiva.component.LevelRestrictComponent;
import cc.sukazyo.messiva.formatter.ILogFormatter;
import cc.sukazyo.messiva.log.ILogLevel;
import cc.sukazyo.messiva.log.Log;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AppenderRestrictableByLevel extends Appender {
	
	@Nonnull public LevelRestrictComponent levelSetting;
	
	public AppenderRestrictableByLevel (@Nullable ILogFormatter formatter) {
		super(formatter);
		levelSetting = new LevelRestrictComponent();
	}
	
	public AppenderRestrictableByLevel () {
		this(null);
	}
	
	@Nonnull
	public AppenderRestrictableByLevel minLevel(@Nonnull ILogLevel minLevel) {
		levelSetting.minLevel(minLevel);
		return this;
	}
	
	@Nonnull
	public AppenderRestrictableByLevel maxLevel(@Nonnull ILogLevel maxLevel) {
		levelSetting.maxLevel(maxLevel);
		return this;
	}
	
	public void pushLog (@Nonnull Log log) {
		if (!levelSetting.checkLevel(log.level())) return;
		pushLogChecked(log);
	}
	
	abstract public void pushLogChecked (@Nonnull Log log);
	
}
