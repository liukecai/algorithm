package design;

public class Single0 {
	private static int version = -1;
	
	private Single0() {
		version++;
	}
	
	private static Single0 instance = null;
	
	public static Single0 getInstance() {
		if (instance == null) 
			instance = new Single0();
		return instance;
	}
	
	public void show() {
		System.out.printf("%d  ", version);
	}
}
