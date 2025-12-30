package cc.sukazyo.messiva.io;

public final class StdIOBinder implements LoggingIOBinder, ActiveIOBinder, PromptIOBinder {
	
	private static final StdIOBinder INSTANCE = new StdIOBinder();
	
	private StdIOBinder () {}
	
	@Override
	public void write (String message) {
		System.out.print(message);
	}
	
}
