package structure;

public class FindInMatrix {

	public FindInMatrix() {}
	
	public static boolean find(int[][] matrix, int number) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int i = 0;
		int j = matrix[0].length - 1;
		
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == number)
				return true;
			
			if (matrix[i][j] > number)
				j--;
			else 
				i++;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1, 2, 8, 9},
										{2, 4, 9, 12},
										{4, 7, 10, 13},
										{6, 8, 11, 15}};
		int number0 = 6, number1 = 5;
		System.out.println("Start");
		boolean f = find(matrix, number0);
		System.out.printf("digit %d in matrix: %s\n", number0, f);
		
		f = find(matrix, number1);
		System.out.printf("digit %d in matrix: %s\n", number1, f);
	}
}
