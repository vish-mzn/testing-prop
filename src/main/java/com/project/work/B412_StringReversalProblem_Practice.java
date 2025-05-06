package com.project.work;

public class B412_StringReversalProblem_Practice {

	/*
	 * Q. Write a function:
	 * 
	 * String Reversal Problem
	 * 
	 * 
	 * 
	 */
	private static String reverseUsingForLoop(String original) {
		
		int len = original.length();
		
		char[] naya = new char[original.length()];
		
		for (int i=0; i<len; i++) {
			naya[i] = original.charAt(len-1-i); 
		}
		
		String reversed = String.valueOf(naya);
		
		return reversed;
	}
	
	private static String reverseUsingStringBuilder(String original) {
		
		StringBuilder strBld = new StringBuilder(original);
		
		String reversed = strBld.reverse().toString();
		
		return reversed;
	}
	
	
	public static void main(String[] args) {
		
		String original = "alphaBetaGamma";
		
		System.out.println("Original string ----" + original);
		
		System.out.println("Reversed using for loop----"+ reverseUsingForLoop(original));
		
		System.out.println("Reversed using for loop----"+ reverseUsingStringBuilder(original));
		
	}
	
	
}
