package com.project.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B413_DistinctNumber_UniqueCharacter_Problem {

	/*
	 * Q. Write a function:
	 * 
	 * Problem:
	 * Given an integer array A, return the number of distinct values.
	 * 
	 * Example:
	 * Input: [2, 1, 1, 2, 3, 1]
	 * Output: 3
	 * 
	 */
	private static int distinctNumberInArray(int[] arr) {
		
		Arrays.sort(arr); //sort the array first 1,1,1,2,2,3
		
		int distinct = arr[0];
		int len = arr.length;
		
		for (int i=1; i<len; i++) {
			if (arr[len-i] != arr[len-i-1]) {
				distinct = arr[i];
			}
		}	
		
		return distinct;
	}
	
	
	/*
	 * Q. Write a function:
	 * 
	 * Problem:
	 * Given a string s, find the index of the first non-repeating character. If none exists, return -1.
	 * 
	 * Example:
	 * Input: "leetcode"
	 * Output: 0
	 * Input: "aabb"
	 * Output: -1
	 * 
	 */
	private static int firstUniqueCharacterInString(String str) {
		int resultIndex = -1;
		
		char[] arr = str.toCharArray();
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		// step 1: put into a Map with the K,V as K=character and V=count
		for (char c : arr) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		for (int i=0; i<arr.length; i++) {
			if (countMap.get(arr[i])==1) {
				return i;
			}
		}
		
		return resultIndex;
	}
	
	
	public static void main(String[] args) {
		
		int[] inputArr = {2, 1, 1, 2, 3, 1, 3, 4, 5, 5, 6, 6};
		
		System.out.println("Distinct number in an Array---"+ distinctNumberInArray(inputArr));	
		
		String str = "vishvas";
		
		System.out.println("First unique character is at---"+ firstUniqueCharacterInString(str));
	}
	
	
}
