package com.project.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A402_Java8_RemoveIf_Problem {

	/*
	 * Q. Example of using removeIf() with stream() - Java 8
	 * 
	 * removeIf() - it changes the original list
	 * 
	 * stream().filter() - it creates a new filtered list, without changing the original list
	 * 
	 */
	public static void main(String[] args) {
		
		System.out.println("Getting back again on to Java\n");
		
		/*
		 * Expression of : removeIf()
		 */
		// list.removeIf(listElement -> condition);
		
		Integer[] input = {1, 3, 2, 4, 5, 7, 6};
		List<Integer> oldNumberList = Arrays.asList(input);
		
		// filter the existing list
		oldNumberList.removeIf(n -> n % 2 != 0);
		
		// filtered to a new list, old list remain untouched
		List<Integer> onlyOdds = oldNumberList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		
		
		
		
		
		List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Kiwi", "Banana", "Fig", "Mango"));
		
		// Find short fruits first
		List<String> shortFruits = fruits.stream()
		                                 .filter(fruit -> fruit.length() < 5)
		                                 .collect(Collectors.toList());
		// Remove them from the original list
		fruits.removeIf(shortFruits::contains);

		System.out.println(fruits); // Output: [Apple, Banana, Mango]
		
		
		/*
		 * if you want one - liner solution then below directly
		 */
		fruits.removeIf(fruit -> fruit.length() < 5);
		
	}
	
	

}
