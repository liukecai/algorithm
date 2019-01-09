package structure;

public class ReplaceSpace {
	private StringBuilder sb = new StringBuilder();

	public ReplaceSpace() {}
	
	public String replace(String src) {
		sb.setLength(0);
		for (char c : src.toCharArray()) {
			if (c == ' ')
				sb.append("%20");
			else
				sb.append(c);
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		ReplaceSpace rs = new ReplaceSpace();
		
		String a = "hello world";
		a = rs.replace(a);
		System.out.println(a);
	}
}
