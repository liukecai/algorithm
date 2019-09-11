package design;

public class Single1 {
	private static int version = -1;
	
	private volatile static Single1 instance;
	
	private Single1() {
		version++;
	}
	
	public static Single1 getInstance() {
		if (instance == null) {
			synchronized(Single1.class) {
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
