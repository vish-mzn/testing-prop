package com.project.work;

import java.util.Arrays;

public class B410_CodilityDemoProblem_Practice {

	/*
	 * Q. Write a function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
	 * 
	 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	 * 
	 * Given A = [1, 2, 3], the function should return 4.
	 * 
	 * Given A = [−1, −3], the function should return 1.
	 * 
	 * Write an efficient algorithm for the following assumptions:
	 * 
	 * N is an integer within the range [1...100,000];
	 * each element of array A is an integer within the range [−1,000,000...1,000,000].
	 * 
	 */
	public static void main(String[] args) {
		
		int[] A = {1, 3, 1, 4, 2, 6};
		
		int output1 = solution(A);
		
		System.out.println("Output1>>>> "+ output1+ "\n");
		
		int[] B = {1, 2, 3};
		
		int output2 = solution(B);
		
		System.out.println("Output2>>>> "+ output2+ "\n");
		
		int[] C = {-1, -3};
		
		int output3 = solution(C);
		
		System.out.println("Output3>>>> "+ output3+ "\n");
	}
	
	
	public static int solution(int[] A) {
		
		int result = 1;
		
		Arrays.sort(A);
		
		for (int element : A) {
			
			if (element > 0 && element != result && element > result) {
				return result;
			}
			if (element >= result) {
				result++;
			}
		}
		return result;
    }
	
	
}
