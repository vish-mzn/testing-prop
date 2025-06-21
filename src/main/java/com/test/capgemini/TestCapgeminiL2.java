package com.test.capgemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCapgeminiL2 {
	
	
	/*
	 * <Praveen Chivukula>
	 * 7.  First Non-repeated character from the String
	 * Ex:
	 * Input : { "array", "apple", "rat"}
	 * Output: y,a,r
	 * 
	 */
	private static List<String> filltering(List<String> inputList) {
		List<String> endOut = new ArrayList<>();
		
		inputList.stream().forEach(input -> {
			List<String> inside = input.chars()
					.mapToObj(c -> String.valueOf((char) c))
					.collect(Collectors.toList());
			
			Map<String, Long> countMap = inside.stream()
					.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
			
			String unique = inside.stream()
					.filter(c -> countMap.get(c) == 1)
					.findFirst()
					.orElse("0");
			
			endOut.add(unique);
		});
		
		return endOut;
	}
	
	

	public static void main(String[] args) {
		List<String> input = List.of("array", "apple", "rat");
		
		List<String>out = filltering(input);
		
		System.out.println(out);
	}

}
