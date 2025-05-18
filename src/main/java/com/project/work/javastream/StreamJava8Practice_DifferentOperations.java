package com.project.work.javastream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamJava8Practice_DifferentOperations {
	
	
	
	
	
	public static void main(String[] args) {

		/*
		 * short-circuiting operation
		 * 
		 */
		List<Double> inputNumbers = Stream.generate(Math::random)
										.limit(4)
										.peek(System.out::print)
										.collect(Collectors.toList());
		
		System.out.println("\n");
		
		/*
		 * stateful operation
		 * 
		 */	
		IntStream.of(12, 34, 65, 17, 22, 27, 88, 36, 38, 17, 22, 88)
									.distinct()
									.sorted()
									.skip(0)
									.forEach(x -> System.out.println(x));
	}

}
