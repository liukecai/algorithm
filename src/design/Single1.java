package design;

public class Single1 {
	private static int version = -1;
	
	private static Single1 instance = null;
	
	private static Object lock = new Object();
	
	private Single1() {
		version++;
	}
	
	public static Single1 getInstance() {
		if (instance == null) {
			synchronized(lock) {
				if (instance == null) 
					instance = new Single1();
			}
		}
		return instance;
	}
	
	public void show() {
		System.out.printf("%d  ", version);
	}
}
