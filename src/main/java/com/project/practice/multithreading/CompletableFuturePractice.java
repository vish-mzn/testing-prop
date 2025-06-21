package com.project.practice.multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturePractice {

	public static void main(String[] args) {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Step 1");
			return "Hello";
		})
		.thenApply(s -> {
			System.out.println("Step 2");
			throw new RuntimeException("Error in Step 2");
		})
		.exceptionally(ex -> {
			System.out.println("Step 3 - Exception handled: "+ ex.getMessage());
			return "Recovered";
		})
		.thenApply(s -> {
			System.out.println("Step 4 - Final result: "+ s);
			return s + " World";
		});
		
		System.out.println("Result: " + future.join());
	}

}
