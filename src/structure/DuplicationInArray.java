package structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DuplicationInArray {
	public DuplicationInArray() {}
	
	public boolean judgeDuplication(int[] arr) {
		if (arr == null || arr.length == 0)
			return false;
		
		int m;
		for (int i = 0; i < arr.length; i++) {
			m = arr[i];
			if (i == m) {
				continue;
				
			} else if (m == arr[m]) {
				return true;
				
			} else {
				int tmp = m;
				arr[i] = arr[m];
				arr[m] = tmp;
				i--;
			}
		}
		
		return false;
	}
	
	public int findOneDuplication(int[] arr) {
		// O(n) = n^2
		
		if (arr == null || arr.length == 0)
			return -1;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (j > arr.length)
					continue;
				if (arr[i] == arr[j])
					return arr[i];
			}
		}
		
		return -1;
	}
	
	public int findOneDuplicationBi(int[] arr) {
		if (arr == null || arr.length == 0)
			return -1;
		int start = 1;
		int end = arr.length - 1;
		
		while(end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(arr, start, middle);
			if (end == start) {
				if (count > 1)
					return start;
				else 
					break;
			}
			
			if (count > (middle - start + 1))
				end = middle;
			else
				start = middle + 1;
		}
		return -1;
	}
	
	private int countRange(int[] arr, int start, int end) {
		if (arr == null || arr.length == 0)
			return 0;
		
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] >= start && arr[i] <= end)
				count++;
		return count;
	}
	
	public List<int[]> generateArray(int number, int length, boolean include0) {
		if (number == 0 || length <= 0)
			return null;
		
		Random random = new Random();
		List<int[]> arrs = new ArrayList<>();
		
		for (int i = 0; i < number; i++) {
			int[] tmp = new int[length];
			for (int j = 0; j < length; j++) {
				if (include0)
					tmp[j] = random.nextInt(length);
				else
					tmp[j] = random.nextInt(length - 1) + 1;
			}
				
			arrs.add(tmp);
		}
		
		return arrs;
	}
	
	public static void printArr(int[] arr) {
		System.out.print("[ ");
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("]");
	}
	
	public void testJudgeDuplication() {
		List<int[]> arrs = generateArray(10, 20, true);
		
		if (arrs == null) {
			System.out.println("null array, exit");
			return;
		}
			
		arrs.add(new int[] {0,1,2,3,4,5,6,7,8,9});
		
		boolean flag = false;
		for (int[] arr : arrs) {
			flag = judgeDuplication(arr);
			System.out.print(" Duplication: " + flag + " ");
			printArr(arr);
		}
	}
	
	public void testFindDuplication() {
		List<int[]> arrs = generateArray(10, 10, false);
		
		if (arrs == null) {
			System.out.println("null array, exit");
			return;
		}
		
		arrs.add(new int[]{1,2,3,4,5,6,4});
		arrs.add(new int[] {});
		int flag;
		
		long start = System.currentTimeMillis();
		
		for (int[] arr : arrs) {
			flag = findOneDuplication(arr);
			System.out.print(" Duplication: " + flag + " ");
			printArr(arr);
		}
		
		System.out.printf("Use time: %d\n\n", System.currentTimeMillis() - start );
		
		start = System.currentTimeMillis();
		
		for (int[] arr : arrs) {
			flag = findOneDuplicationBi(arr);
			System.out.print(" Duplication: " + flag + " ");
			printArr(arr);
		}
		
		System.out.printf("Use time: %d\n", System.currentTimeMillis() - start );
	}
	
	public static void main(String[] args) {
		DuplicationInArray dup = new DuplicationInArray();
		// dup.testJudgeDuplication();
		dup.testFindDuplication();
	}
}
