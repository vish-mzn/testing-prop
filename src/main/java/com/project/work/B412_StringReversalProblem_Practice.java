package com.project.work;

public class B412_StringReversalProblem_Practice {

	/*
	 * Q. Write a function:
	 * 
	 * String Reversal Problem
	 * 
	 */
	
	
	private static String reverseUsingForLoop(String original) {
		
		int len = original.length();
		
		char[] reversed = new char[original.length()];
		
		for (int i=0; i<len; i++) {
			reversed[i] = original.charAt(len-1-i); 
		}
		
		String reverseString = String.valueOf(reversed);
		
		return reverseString;
	}
	
	private static String reverseUsingStringBuilder(String original) {
		
		StringBuilder strBld = new StringBuilder(original);
		
		String reversed = strBld.reverse().toString();
		
		return reversed;
	}
	
	
	
	// E.g. Input: Automation, Output: noitamotuA
	// Please don't use method such as s.reverse()
	private static String reverseStringWithoutUsingReverseMethod(String original) {
		StringBuilder reversed = new StringBuilder();
		
		for (int i=original.length()-1; i>=0; i--) {
			reversed.append(original.charAt(i));
		}
		return reversed.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String original = "AlphaBetaGamma";
		
		System.out.println("Original string ----" + original);
		
		System.out.println("Reversed using for loop----"+ reverseUsingForLoop(original));
		
		System.out.println("Reversed using StringBuilder reverse method----"+ reverseUsingStringBuilder(original));
		
		System.out.println("Reversed using StringBuilder and reversed forLoop----"+ reverseStringWithoutUsingReverseMethod(original));
		
		
	}
	
	
}
