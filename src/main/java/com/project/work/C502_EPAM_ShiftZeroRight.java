package com.project.work;

public class C502_EPAM_ShiftZeroRight {

	/*
	 * ✅ Problem Statement:
	 * Given an integer array, shift all the zeros to the right without changing the relative order of the non-zero elements.
	 * 
	 * Example:
	 * Input:  [0, 1, 0, 3, 12]
	 * Output: [1, 3, 12, 0, 0]
	 */
	
	
	/*
	 * Approach : Placing the non-zero elements to the front
	 * 
	 */
	public static int[] shiftZerosRight(int[] arr) {
		int index = 0;									//index where next non-zero element you need to place
		
		for (int i = index; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index] = arr[i];
				index++;
			}
		}
		
		while (index < arr.length ) {
			arr[index] = 0;
			index++;
		}
		
		return arr;
	}
	
	
	/*
	 * Approach : shifting the zeros to right using the swap method
	 * 
	 */
	public static int[] shiftZerosUsingSwap(int[] arr) {
		int zeroPos = 0;								//Points to where the next non-zero should be swapped
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] != 0) {
                if (i != zeroPos) {
                    // Swap arr[i] and arr[zeroPos]
                    int temp = arr[i];
                    arr[i] = arr[zeroPos];
                    arr[zeroPos] = temp;
                }
                zeroPos++;
            }
		}
		
		return arr;
	}
	
	
	
	public static void printArray(int[] arr) {
		System.out.println("Array after shifting zeros to right: ");
		int i = 0;
		while (i < arr.length) {
			System.out.println(arr[i] + " ");
			i++;
		}
		System.out.println("----------");
	}
	
	
	
	public static void main(String[] args) {
		int[] input = {1, 0, 3, 0, 2, 58, 0};

		printArray(shiftZerosRight(input));
		
		int[] input2 = {1, 0, 3, 0, 2, 58, 0};
		
		printArray(shiftZerosUsingSwap(input2));
		
	}
	
	
}
