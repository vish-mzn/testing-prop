package com.project.work.javastream;

import java.util.HashMap;
import java.util.Map;

public class StreamJava8_EPAM_UniqueCharacterCount {
	
	/*
	 * ✅ Problem Statement:
	 * Given a string, determine the maximum number of occurrences of any single character.
	 * If two or more characters have the same highest count, choose any one of them.
	 * 
	 * Return:
	 * true if the maximum count is even
	 * false if the maximum count is odd
	 */
	private static boolean uniqueCharacterCount(String input) {
		
		char[] arr = input.toCharArray();
		Map<Character, Integer> countMap = new HashMap<>();
		
		// step 1: put into a Map with the K,V as K=character and V=count
		for (char c : arr) {
			countMap.put(c, countMap.getOrDefault(c, 0) +1);
		}
		
		// step 2: this max count is something you need to think a bit, how to find using Java stream
		int maxCount = countMap.values().stream()
			.max(Integer::compareTo)
			.orElse(0);
		
		// another explanation of comparing the min / max
		int maxCoun = Integer.MIN_VALUE;
		for (int count : countMap.values()) {
			maxCoun = Math.max(count, maxCoun);
		}
		
		return maxCount % 2 == 0;
	}
	
	
	
	public static void main(String[] args) {
		String input = "aabbccbcc";
		System.out.println("Boolean: " + uniqueCharacterCount(input));
		
	}

}
