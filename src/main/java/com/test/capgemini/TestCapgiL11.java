package com.test.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCapgiL11 {
	
	
	/*
	 * First capgemini L1 round
	 * Q: Find the second highest length
	 * List<String> list = {Apple, Cherry, Kiwi};
	 * 
	 */
	private static String secondhighestLength(List<String> input) {
		
//		Arrays.sort(input);
		Optional<String> output = input.stream()
				.sorted(Comparator.comparing(String::length).reversed())
//				.sorted((str1, str2) -> str1.length() > str2.length())
				.skip(1)
				.findFirst();
		
		return output.get();
	}
	
	
	/*
	 * Second capgemini L1 round
	 * Q: Reverse the string using Java Stream
	 * 
	 * eg. input = "vishesh"
	 * output = "hsehsiv"
	 * 
	 */
	private static String reverseString(String input) {
		
		char arr[] = input.toCharArray();
		
		List<String> newList = new ArrayList<>();
		
		for(char el : arr) {
			newList.add(String.valueOf(el));
		}
		
		String reversed = IntStream.range(0, newList.size())
				.mapToObj(i -> newList.get(newList.size()-1-i))
				.collect(Collectors.joining());
		
		System.out.println("Reversed string:  "+ reversed);
		
		return reversed;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		// Find second highest length
		List<String> input = List.of("apple", "cherry", "kiwi", "straberry");
		System.out.println(secondhighestLength(input));
		
		// reverse the string - using java stream
		String inputString = "vishesh";
		System.out.println("Input String:  " + inputString);
		System.out.println("Reversed string:  "+ reverseString(inputString));
		
		
		
	}
	
	
	
}
