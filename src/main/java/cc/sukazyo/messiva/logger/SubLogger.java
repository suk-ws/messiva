package cc.sukazyo.messiva.logger;

import cc.sukazyo.messiva.log.Log;
import cc.sukazyo.messiva.logger.wrapper.ConcreteAbstractLogger;

import javax.annotation.Nonnull;

public class SubLogger implements Logger, ConcreteAbstractLogger {
	
	@Nonnull private final Logger parent;
	@Nonnull private final String name;
	@Nonnull private final String[] fullName;
	
	public SubLogger (@Nonnull Logger parent, @Nonnull String name) {
		this.parent = parent;
		this.name = name;
		this.fullName = new String[parent.getFullName().length + 1];
		System.arraycopy(parent.getFullName(), 0, this.fullName, 0, parent.getFullName().length);
		this.fullName[this.fullName.length - 1] = name;
	}
	
	@Nonnull
	@Override
	public AbstractLogger self () {
		return this;
	}
	
	@Nonnull
	@Override
	public String getName () {
		return this.name;
	}
	
	@Nonnull
	@Override
	public String[] getFullName () {
		return this.fullName;
	}
	
	@Nonnull
	@Override
	public Logger getLogger (@Nonnull String name) {
		return new SubLogger(this, name);
	}
	
	@Override
	public void receiveLog (@Nonnull Log log) {
		parent.receiveLog(log);
	}
	
}
