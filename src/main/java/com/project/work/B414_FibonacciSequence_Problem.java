package com.project.work;

public class B414_FibonacciSequence_Problem {

	/*
	 * Q. Write a function:
	 * 
	 * To print the Fibonacci Sequence
	 * 
	 */
	private static int fibonacciUsingRecursion(int len) {
		if (len<=1) {
			return len;
		}
		
		return fibonacciUsingRecursion(len-1) + fibonacciUsingRecursion(len-2);
	}
	
	
	public static void printSequence(int length) {
		for (int i=0; i<length; i++) {
			System.out.println(fibonacciUsingRecursion(i));
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int fibLength = 10;
		printSequence(fibLength);
	}
	
	
}
