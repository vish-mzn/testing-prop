package com.test.freecharge;

public class FindNumberPresent {
	
	/*
	 * 
	 * integer array is the sorted
	 * 
	 * input: int[] arr = {1, 4, 6, 7, 10, 12, 14, 15, 16, 22, 23, 25, 27};
	 * 
	 * output: return 0 / or difference of the immediate right and immediate left number 
	 * 
	 */
	private static Integer find(int[] array, int input) {
		
		int middleIndex = array.length / 2;
		
		int middleElement = array[middleIndex];
		int extra = 0;
		
		if (input == middleElement) return 0;
		
		if (input>middleElement) {
			for (int j = middleIndex; j < array.length; j++) {
				if (input == array[j]) return 0; 
				if (input < array[j]) {
					return array[j] - array[j-1];
				}
			}
		} else {
			for (int j = 0; j < middleIndex; j++) {
				if (input == array[j]) return 0;
				
				if (input < array[j]) {
					return array[j] - array[j-1];
				}
				extra = array[j];
			}
		}
		return middleElement - extra;
	}
	
	

	public static void main(String[] args) {
		
		int[] arr = {
				1, 4, 6, 7, 10, 12, 14, 15, 16, 22, 23, 25, 27
		};
		System.out.println(find(arr, 8));
	}

}
