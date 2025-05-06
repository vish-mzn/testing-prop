package com.project.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A401_UnpairedNumber_Problem {
	
	/*
	 * Q. If the element occurs twice or occurs in the even number (means paired)
	 * And there is unique number present which is unpaired
	 * then How to find unique number
	 * 
	 * 
	 * 
	 * A. Most efficient way : By Using the XOR operation {O[N]}
	 * 
	 * B. By sorting and then finding out the unique number {O[N Log N]} 
	 *  
	 */
	private static int findOddOneOut_UsingXOR(int[] arr) {
		int result = -1;
		
		for (int num : arr) {
			result ^= num;
		}
		return result;
	}
	
	/*
	 * C. By using the MAP data structure
	 */
	private static int findOddOneOut_UsingMAP(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		
		for (int num : arr) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				return entry.getKey();
			}
		}
		
		return -1;
	}
	
	private static int findOddOneOut_SortingAndTraverse(int[] arr) {
		
		Arrays.sort(arr);
		
		for (int i=0; i<arr.length; i += 2) {
			if (arr[i]!=arr[i+1]) {
				return arr[i];
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Lets get back again on to Java\n");
		
		int[] input = {9, 3, 9, 3, 9, 7, 9, 7, 5, 5};
		
		Arrays.sort(input);
		
		System.out.println("Input arr:\n"+ Arrays.toString(input));
		
		int output1 = findOddOneOut_UsingXOR(input);
		
		System.out.println("Output_UsingXOR:\n"+output1);
		
		int output2 = findOddOneOut_UsingMAP(input);
		
		System.out.println("Output_UsingMAP:\n"+output2);
		
		int output3 = findOddOneOut_SortingAndTraverse(input);
		
		System.out.println("Output_UsingSorting:\n"+output3);
	}
	

}
