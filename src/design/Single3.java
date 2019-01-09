package design;

public class Single3 {
	private static int version = -1;
	
	private Single3() {
		version++;
	}
	
	public static final Single3 getInstance() {
		return Single3Holder.instance;
	}

	private static class Single3Holder {
		public static final Single3 instance = new Single3();
	}
	
	public void show() {
		System.out.printf("%d  ", version);
	}
}
