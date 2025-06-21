package com.practice.bajaj;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindEquilibriumIndex {
	
	
	/*
	 * Q) Find index in array where right sum = left sum(EquilibriumIndex)
	 * 
	 * explaination : sum of elements from 0 to i-1 == sum of elements from i+1 to end
	 * here i = equilibrium index
	 */
	private static int equilibriumIndex(int[] array) {
		int totalSum = IntStream.range(0, array.length)
				.map(i -> array[i])
				.reduce(0, Integer::sum);
//		int totalSum = Arrays.stream(array).reduce(0, Integer::sum);
//		int totalSum = Arrays.stream(array).sum();
		System.out.println("Total Sum: "+ totalSum);
		
		int leftSum = 0;
		
		for (int j=0; j<array.length; j++) {
			int rightSum = totalSum - leftSum - array[j];
			
			if(rightSum == leftSum) return j;
			
			leftSum = leftSum + array[j];
		}		
		return -1; // no equilibrium index
	}
	

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println(equilibriumIndex(arr));
		
	}

}
