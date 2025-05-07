package com.project.work.javastream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJava8Practice_Easy {
	
	/*
	 * filter even numbers from a list 
	 * 
	 */
	private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
		List<Integer> filtererd = numbers.stream()
										.filter(element -> element % 2 == 0)
										.collect(Collectors.toList());
		return filtererd;
	}
	
	
	/*
	 * filter Words starting with "A"
	 * 
	 */
	private static List<String> filterALetterWords(List<String> names) {
		
		List<String> filtered = names.stream()
									.filter(name -> name.startsWith("A"))
									.map(String::toUpperCase)
									.collect(Collectors.toList());
		return filtered;
	}
	
	
	/*
	 * filter numbers greater than 10
	 * 
	 */
	private static List<Integer> filterGreaterNumbers(List<Integer> numbers) {
		List<Integer> filtererd = numbers.stream()
										.filter(element -> element > 10)
										.sorted(Comparator.reverseOrder())
										.collect(Collectors.toList());
		return filtererd;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// Filtering even numbers
		List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println("Input List: " +inputNumbers);
		System.out.println("Even numbers: " +filterEvenNumbers(inputNumbers));
		// Output: [2, 4, 6]
		
		
		// Filtering names string with 'A'
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Amal", "Anita", "Vishesh");
		System.out.println("Input names: " +names);
		System.out.println("Filtered names: " +filterALetterWords(names));
		// Output: ["ALICE", "AMAL", "ANITA"]
		
		
		// Number greater than 10
		List<Integer> list = Arrays.asList(5, 15, 10, 25, 8, 11, 13, 29);
		System.out.println("Input List: " +list);
		System.out.println("Greater than 10 numbers: " +filterGreaterNumbers(list));
		// Output: [29, 25, 15, 13, 11]
		
	}

}
