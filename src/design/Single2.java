package design;

public class Single2 {
	private static int version = -1;
	private static Single2 instance = new Single2();
	
	private Single2() {
		version++;
	}
	
	public static Single2 getInstance() {
		return instance;
	}
	
	public void show() {
		System.out.printf("%d  ", version);
	}
}
