package com.project.work.javastream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamJava8Practice_Medium {
	
	/*
	 * remove duplicate elements and sort the list
	 * 
	 */
	private static List<Integer> removeDuplicates(List<Integer> numbers) {
		List<Integer> filtererd = numbers.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		// understanding reduce in a better way
		int sumMethodReference = numbers.stream()
				.reduce(0, Integer::sum);
		System.out.println("Reduce1: --- " + sumMethodReference);
		
		
		int sumInLine = IntStream.of(23, 5, 12 , 78, 45).reduce(0, (x, y) -> x+y);
		System.out.println("Reduce2: --- " + sumInLine);
		
		
		int sum = IntStream.of(23, 5, 12 , 78, 45).reduce(0, (x,y) -> {
			System.out.println("x: "+ x +" :: y: "+ y);
			return x+y; // returns x+y as x for the next combining operation 
		});
		
		
		int min = IntStream.of(23, 5, 12, 78, 45).reduce(Integer.MIN_VALUE, (x, y) -> x>y ? y:x);
		int minMethodReference = IntStream.of(23, 5, 12, 78, 45).reduce(Integer.MIN_VALUE, Math::min);
		
		int max = IntStream.of(23, 5, 12, 78, 45).reduce(Integer.MAX_VALUE, (x, y) -> x>y ? x:y);
		int maxMethodReference = IntStream.of(23, 5, 12, 78, 45).reduce(Integer.MAX_VALUE, Math::max);
		
		System.out.println("IntStream min: "+ min);
		System.out.println("IntStream minMethodReference: "+ minMethodReference);
		
		System.out.println("IntStream min: "+ max);
		System.out.println("IntStream minMethodReference: "+ maxMethodReference);
		
		Map<Boolean, List<Integer>> partitioned = numbers.stream()
				.collect(Collectors.partitioningBy(n -> n%2 ==0));
		System.out.println("Partitioning map into odd even: ---" + partitioned);
		
		return filtererd;
	}
	
	
	/*
	 * Get a map of name to length
	 * 
	 */
	private static Map<String, Integer> mapofNameTolength(List<String> elements) {
		Map<String, Integer> resultMap = elements.stream()
				.collect(Collectors.toMap(
						word -> word, 
						word -> word.length()));
		return resultMap;
	}
	
	
	/*
	 * find min and max from a list
	 * 
	 */
	private static Integer filterMinMaxFromList(List<Integer> numbers) {
		int min = numbers.stream()
				.min(Integer::compareTo)
				.orElseThrow();
		
		int max = numbers.stream()
				.max(Integer::compareTo)
				.orElseThrow();
		
		return max;
	}
	
	
	/*
	 * join strings with *
	 * 
	 */
	private static String joinStringWithStar(List<String> elements) {
		String concatenated = elements.stream()
				.collect(Collectors.joining("*"));
		return concatenated;
	}
	
	
	/*
	 * flattening of List of List of String
	 * 
	 */
	private static List<String> flatteningListOfLists(List<List<String>> elements) {
		List<String> flattenList = elements.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());
		return flattenList;
	}
	
	
	
	public static void main(String[] args) {
		// Filtering remove duplicate elements and sort the list
		List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 3, 6, 6, 5, 12);
		System.out.println("Input List: " +inputNumbers);
		System.out.println("Remove duplicates and sort the list: " +removeDuplicates(inputNumbers)+"\n");
		// Output: 
		
		
		// Filtering map of name to length
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Amal", "Anita", "Vishesh");
		System.out.println("Input names: " +names);
		System.out.println("Map of name to length: " +mapofNameTolength(names)+"\n");
		// Output: 
		
		
		// Mim Max number
		List<Integer> list = Arrays.asList(5, 15, 10, 25, 8, 11, 13, 29);
		System.out.println("Input List: " +list);
		System.out.println("Max number from List: " +filterMinMaxFromList(list)+"\n");
		// Output: 
		
		
		// join strings with *
		List<String> stringlist = Arrays.asList("Alice", "Bob", "Charlie", "Amal", "Anita", "Vishesh");
		System.out.println("Input names: " +stringlist);
		System.out.println("Concatenated string: " +joinStringWithStar(stringlist)+"\n");
		// Output: 
		
		
		// flatten a list of lists
		List<List<String>> nestedList = Arrays.asList(List.of("a", "b"), List.of("c", "d", "f"));
		System.out.println("Input names: " +nestedList);
		System.out.println("Flattened List string: " +flatteningListOfLists(nestedList)+"\n");
		// Output: 
		
		
	}

}
