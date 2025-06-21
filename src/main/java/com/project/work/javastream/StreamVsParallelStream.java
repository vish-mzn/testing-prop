package com.project.work.javastream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamVsParallelStream {

	public static void main(String[] args) {
		List<Integer> numbers = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		
		
		// Sequential stream
		long start = System.currentTimeMillis();
		List<Integer> squaredSequential = numbers.stream()
				.map(n -> {
					System.out.println("Processing " + n + " in thread " + Thread.currentThread().getName());
					
					return simulateWork(n);
				})
				.collect(Collectors.toList());
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("Sequential Time: "+ duration + " ms \n");
		
		
		// Parallel stream
		start = System.currentTimeMillis();
		List<Integer> squaredParallel = numbers.parallelStream()
				.map(n -> {
					System.out.println("Processing " + n + " in thread " + Thread.currentThread().getName());
					
					return simulateWork(n);
				})
				.collect(Collectors.toList());
		duration = System.currentTimeMillis() - start;
		System.out.println("Parallel Time: "+ duration + " ms");
	}
	
	
	
	private static int simulateWork(int n) {
		try {
			Thread.sleep(100); // Simulate CPU work
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return n*n;
	}

}
