package algorithms;

public class Fibonacci {
	public static long getFib(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		
		return getFib(n - 1) + getFib(n - 2);
	}
	
	public static double getFib2(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		
		double[] excel = new double[n + 1];
		excel[0] = 0;
		excel[1] = 1;
		
		for (int i = 2; i <= n; i++) 
			excel[i] = excel[i-1] + excel[i-2];
		
		return excel[n];
	}
	
	public static double getFib3(int n) {
		if (n <= 0) 
			return 0;
		if (n == 1)
			return 1;
		
		double fibMinusOne = 1;
		double fibMinusTwo = 0;
		double fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibMinusOne + fibMinusTwo;
			
			fibMinusTwo = fibMinusOne;
			fibMinusOne = fibN;
		}
		return fibN;
	}
	
	public static double getFib4(int n) {
		double[][] fib0 = {{1, 1}, {1, 0}};
		double[][] fibn = fibMatrix(n - 1, fib0);
		return fibn[0][0];
	}
	
	private static double[][] fibMatrix(int n, double[][] matrix) {
		if (n <= 1)
			return matrix;
		
		double[][] tmp;
		if (n % 2 == 0) {
			tmp = fibMatrix(n/2, matrix);
			try {
				tmp = matrixMulti(tmp, tmp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tmp;
		} else {
			tmp = fibMatrix((n-1)/2, matrix);
			try {
				tmp = matrixMulti(tmp, tmp);
				tmp = matrixMulti(tmp, matrix);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tmp;
		}
	}
	
	private static double[][] matrixMulti(double[][] matrix1, double[][] matrix2) throws Exception {
		if (matrix1 == null || matrix2 == null)
			return null;
		if (matrix1[0].length != matrix2.length)
			throw new Exception("matrix row != cloumn");
		
		double[][] tmp = new double[matrix1[0].length][matrix2.length];
		double data = 0;
		for (int i = 0; i < matrix1[0].length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				data = 0;
				for (int k = 0; k < matrix2.length; k++)
					data += matrix1[i][k] * matrix2[k][j];
				tmp[i][j] = data;
			}
		}
		return tmp;	
	}
	
	public static void main(String[] args) throws Exception {
		int n = 100;
		long start = System.currentTimeMillis();
		
		//System.out.println(getFib(n));
		//System.out.println("Time: " + (System.currentTimeMillis() - start));
		
		//start = System.currentTimeMillis();
		System.out.println(getFib2(n));
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		System.out.println(getFib3(n));
		System.out.println("Time: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		System.out.println(getFib4(n));
		System.out.println("Time: " + (System.currentTimeMillis() - start));
	}
}
