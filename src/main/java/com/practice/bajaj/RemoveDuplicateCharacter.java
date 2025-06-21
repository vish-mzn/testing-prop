package com.practice.bajaj;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class RemoveDuplicateCharacter implements Runnable, Callable<Integer> {
	
	/*
	 * Q) Remove duplicate from strings
	 * 
	 * explaination: 
	 */
	private static String removeDuplicates(String input) {
		Set<Character> characterSet = new LinkedHashSet<>();
		for (char c : input.toCharArray()) characterSet.add(c);
		
		StringBuilder sb = new StringBuilder();
		for(char c : characterSet) sb.append(c);
		
		return sb.toString();
		
	}
	

	public static void main(String[] args) {
		
		String input = "programming";
		
		System.out.println(removeDuplicates(input));

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
