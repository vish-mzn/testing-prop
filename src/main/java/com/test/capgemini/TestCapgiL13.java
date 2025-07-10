package com.test.capgemini;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCapgiL13 {
	
	/*
	 * Third capgemini L1 round
	 * Q: Find the count of each character and return result in sorted order
	 * 
	 * eg. input = "vishesh"
	 * output = [e=1, v=1, i=1, s=2, h=2]
	 * 
	 */
	public static void main(String[] args) {
		
		String input = "vishesh";
		
		char[] ch = input.toCharArray();
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		for (char c : ch) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1 );
		}
		
		Map<Character, Integer> newMap = countMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new));
		
		List<Map.Entry<Character, Integer>> list = countMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());
		
		System.out.println(countMap);
		
		System.out.println(newMap);
		
		System.out.println(list); // prints the sorted value
	}

}
