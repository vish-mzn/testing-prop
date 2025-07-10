package com.test.altimetrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestFirstNonRepeatingElement {
	
	
	/*
	 * str = "naman"
	 * Find the first non repeating character from the string
	 * 
	 * List<String> list = input.chars()
			.mapToObj(c -> String.valueOf((char) c))
			.collect(Collectors.toList());
	 *  
	 */
	private static void findingUsingCountMap(String input) {
		char[] array =  input.toCharArray();
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		for (char c : array) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		for (char c : array) {
			if (countMap.get(c) == 1) {
				System.out.println("First non-repeating element is: "+ c);
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		
		String input = "naman";
		
		findingUsingCountMap(input);
	}

}
