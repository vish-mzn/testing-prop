package com.test.bp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingNumber {

	
	/*
	 * Q: Below integer arrays are incremental, could be ordered or unordered, find the missing element in between.
	 * 
	 * [1, 2, 3, 4, 5, 6, 8] = 7
	 * [1, 6, 3, 4, 2] = 5
	 * 
	 */
	public static void main(String[] args) {
		
		int[] array1 = { 1, 2, 3, 4, 5, 6, 8 };	//missing = 7
		int[] array2 = { 1, 6, 3, 4, 2 };		//missing = 5
		
		System.out.println("Output array1:  " + findMissingElement(array1) + "\n");
		System.out.println("Output array2:  " + findMissingElement(array2) + "\n");
		
		System.out.println("Output array1 using java 8:  " + findMissingUsingJava8(array1) + "\n");
		System.out.println("Output array2 using java 8:  " + findMissingUsingJava8(array2) + "\n");
	}
	
	
	
	
	private static int findMissingElement(int[] input) {
		
		Arrays.sort(input);
		int counter = input[0];
		
		for (int i: input) {
			if (i != counter)
				return counter;
			counter++;
		}
		return 0;
	}
	
	
	
	private static int findMissingUsingJava8(int[] input) {
		
		List<Integer> list = Arrays.stream(input).sorted().boxed().collect(Collectors.toList());
		
		OptionalInt result = IntStream.range(0, list.size()-1)
				.filter(i -> list.get(i+1) - list.get(i) > 1)
				.map(i -> list.get(i)+1)
				.findFirst();
		
		return result.orElse(0);
	}
	

}
