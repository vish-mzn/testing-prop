package com.test.altimetrix;

import java.util.HashMap;
import java.util.Map;

public class TestAltimetrix {
	
	
	/*
	 * str = "naman"
	 * Find the first non repeating character from the string
	 *  
	 */
	
	private static String usingXORoperation(String input) {
		
		char[] arr = input.toCharArray();
		char[] newAr = new char[input.length()];
		int index=0;
		
		for (char c : arr) {
			c ^= c;
			newAr[index] = c;
		}
		
		return String.valueOf(newAr[0]);
	}
	
	private static void usingCountMap(String input) {
		char[] arr = input.toCharArray();
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		for (char c : arr) {
			countMap.put(c, countMap.getOrDefault(c, 0) +1);
		}
		
		for (char c : arr) {
			if (countMap.get(c) == 1 ) {
				System.out.println("First non-repeating element:  " + c);
				break;
			}
		}
		
	}
	

	public static void main(String[] args) {
		String input = "naman";
		
		usingCountMap(input);

	}

}
