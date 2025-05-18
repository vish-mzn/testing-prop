package com.project.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B415_NumberProblems_Practice {
	
	
	
	/*
	
	| Character | ASCII / Unicode Value |
	| --------- | --------------------- |
	| `'A'`     | 65                    |
	| `'Z'`     | 90                    |
	| `'a'`     | 97                    |
	| `'z'`     | 122                   |
	| `'0'`     | 48                    |
	| `'9'`     | 57                    |

	*/	
	
	// Sort the integer in ASC order without using the built-in method such as ArrayUtils.sort
	/*
	 * Simple Bubble sort
	 * meaning we take first number [first for loop] [0 -> length-1]
	 * then iterate through the complete list [second for loop] [0 -> length-i-1]
	 * and put at the correct place if it is greater by swapping
	 * 
	 * the largest number bubbles up
	 * 
	 */
	  public static int[] bubbleSortIntegers(int[] array) {
	    // Simple bubble sort
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					// Swap
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
		        }
			}
		}
		return array;
	  }
	
	
	// sort the given String in ASC order without using method like Arrays.sort
	/*
	 * Again using the Bubble sort
	 */
	  public static char[] sortStringInAscOrder(String input) {
	    char[] chars = input.toCharArray();
	    // Bubble sort
	    for (int i = 0; i < chars.length - 1; i++) {
	      for (int j = 0; j < chars.length - i - 1; j++) {
	        if (chars[j] > chars[j + 1]) {
//	        if (Character.toLowerCase(chars[j]) > Character.toLowerCase(chars[j + 1])) {  // case-insensitive comparison 
	          char temp = chars[j];
	          chars[j] = chars[j + 1];
	          chars[j + 1] = temp;
	        }
	      }
	    }
	    return chars;
	  }
	
	
	  
	  
	// Given a Alphanumeric, please return a character with the lowest occurrence
	  // E.g. AbcdAbc123123, the answer is d as it only occurs once
	  // If there is more than 1 char with the same lowest occurrence, return the first char in ASC order
	  public static char lowestOccurrence(String input) {
	    // Count occurrences of each character
	    Map<Character, Integer> charCount = new HashMap<>();

	    // Populate the map with character counts
	    for (char c : input.toCharArray()) {
	      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
	    }

	    // Find the minimum occurrence count
	    int minCount = Integer.MAX_VALUE;
	    for (int count : charCount.values()) {
	      minCount = Math.min(minCount, count);
	    }
	    
	    int minCaont = charCount.values().stream()
	    		.min(Integer::compareTo)
	    		.orElse(0);

	    // Find characters with minimum occurrence and pick the first one in ASC order
	    // entry.getKey() < result == this will compare the ASCII values 
	    char result = Character.MAX_VALUE; // Initialize with highest possible char value
	    for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
	      if (entry.getValue() == minCount && entry.getKey() < result) {
	        result = entry.getKey();
	      }
	    }

	    return result;
	  }
	  
	  
	  
	  
	// Given an input, please apply the provided equations (+, -, x, /)
	  // E.g. input: 1.5, equations: x*2, x+10/2, x*1.5-6
	  // Answer: 1st equation: x*2 = 1.5*2 = 3
	  //         2nd equation: x+10/2 = 3+10/2 = 8
	  //         3rd equation: x*1.5-6 = 8*1.5-6 = 6
	  //         return 6.0
	  public static double solveEquations(double input, String[] equations) {
	    for (String equation : equations) {
	      // Step 1: Replace 'x' with the current value (input)
	      // This substitutes the result from previous equation into the current equation
	      String expr = equation.replace("x", Double.toString(input));

	      // Step 2: Tokenize expression into operands and operators
	      // We'll store numbers and operators separately to handle operator precedence
	      List<Double> numbers = new ArrayList<>();
	      List<Character> operators = new ArrayList<>();
	      StringBuilder numBuilder = new StringBuilder();

	      for (int i = 0; i < expr.length(); i++) {
	        char ch = expr.charAt(i);
	        // Handle digits, decimal points, and negative numbers
	        // A negative sign is treated as part of the number if it's at the beginning or after another operator
	        if (Character.isDigit(ch) || ch == '.'
	          || (ch == '-'
	          && (i == 0 || "+-*/".indexOf(expr.charAt(i - 1)) != -1))) {
	          numBuilder.append(ch);
	        } else if ("+-*/".indexOf(ch) != -1) {
	          // Found an operator - add the completed number to our list
	          numbers.add(Double.parseDouble(numBuilder.toString()));
	          numBuilder.setLength(0); // clear the builder
	          operators.add(ch);       // add the operator to our list
	        }
	        // Ignore any other characters (like spaces)
	      }
	      // Add the last number (after the final operator)
	      numbers.add(Double.parseDouble(numBuilder.toString()));

	      // Step 3: Evaluate the expression using operator precedence
	      // First handle multiplication and division (higher precedence)
	      for (int i = 0; i < operators.size(); ) {
	        char op = operators.get(i);
	        if (op == '*' || op == '/') {
	          double left = numbers.get(i);
	          double right = numbers.get(i + 1);
	          double result;

	          if (op == '*') {
	            result = left * right; // Perform multiplication
	          } else {
	            result = left / right; // Perform division
	          }

	          // Replace the left operand with the result
	          numbers.set(i, result);
	          // Remove the right operand since it's now part of the result
	          numbers.remove(i + 1);
	          // Remove the processed operator
	          operators.remove(i);
	          // Don't increment i since we've removed an operator and need to process the next one at the same index
	        } else {
	          i++; // Skip addition/subtraction operators for now
	        }
	      }

	      // Then handle addition and subtraction (lower precedence)
	      for (int i = 0; i < operators.size(); ) {
	        char op = operators.get(i);
	        double left = numbers.get(i);
	        double right = numbers.get(i + 1);
	        double result;

	        if (op == '+') {
	          result = left + right; // Perform addition
	        } else {
	          result = left - right; // Perform subtraction
	        }

	        // Replace the left operand with the result
	        numbers.set(i, result);
	        // Remove the right operand
	        numbers.remove(i + 1);
	        // Remove the processed operator
	        operators.remove(i);
	        // No need to increment i as we always process the operator at the current position
	      }

	      // Step 4: The final result becomes the input for the next equation
	      input = numbers.get(0);
	      System.out.println("Result per equation: " + input);
	    }
	    return input; // Return the final result after processing all equations
	  }
	  
	  
	  
	  
	  
	  
	  
	
	
	public static void main(String[] args) {
		
		int[] original = {1,23,54,32,20,18,21,13,10,7,8,4,22};
		
		System.out.println("Sorting integer array using Bubble sorting: ");
		for (int i : bubbleSortIntegers(original)) {
			System.out.println(i);
		}
		
		
		
		
		
	}
	
	
}
