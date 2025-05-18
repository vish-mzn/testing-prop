package com.javaassignment.hlb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaTestCompleted {

  // E.g. Input: Automation, Output: noitamotuA
  // Please don't use method such as s.reverse()
  public static String reverseStringWithoutUsingStringMethod(String s) {
    StringBuilder reversed = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      reversed.append(s.charAt(i));
    }
    return reversed.toString();
  }

  // Sort the integer in ASC order without using the built-in method such as ArrayUtils.sort
  public static Integer[] sortIntegers(Integer[] array) {
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

  // Check if the given date is within the date range
  public static boolean isInDateRange(Date givenDate, Date startDate, Date endDate) {
    // Returns:
    // the value 0 if the argument Date is equal to this Date; a value less than 0
    // if this Date is before the Date argument; and a value greater than 0 if this
    // Date is after the Date argument.
    return givenDate.compareTo(startDate) >= 0 && givenDate.compareTo(endDate) <= 0;
  }

  // sort the given String in ASC order without using method like Arrays.sort
  public static char[] sortStringInAscOrder(String input) {
    char[] chars = input.toCharArray();
    // Bubble sort
    for (int i = 0; i < chars.length - 1; i++) {
      for (int j = 0; j < chars.length - i - 1; j++) {
        if (chars[j] > chars[j + 1]) {
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

    // Find characters with minimum occurrence and pick the first one in ASC order
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
    System.out.println("Test 1: " + reverseStringWithoutUsingStringMethod("Automation"));
    Integer[] intArray = new Integer[] {10, 12, 54, 1, 2, -9, 8};
    System.out.print("Test 2: ");
    for (Integer i : intArray) {
      System.out.print(i + ", ");
    }
    System.out.println();
    System.out.print("Test 2 After applying sorting: ");
    sortIntegers(intArray);
    for (Integer i : intArray) {
      System.out.print(i + ", ");
    }

    System.out.println();
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      Date startDate = sdf.parse("2024-12-01 13:09:22");
      Date endDate = sdf.parse("2025-01-09 20:10:12");
      Date givenDate = sdf.parse("2025-02-02 00:11:22");
      System.out.println("Test 3: " + isInDateRange(givenDate, startDate, endDate));
    } catch (Exception e) {
      System.out.println(e);
    }

    char[] sorted = sortStringInAscOrder("testingNG311");
    System.out.print("Test 4 :");
    for (char c : sorted) {
      System.out.print(c + ", ");
    }
    System.out.println();
    System.out.println("Test 5: " + lowestOccurrence("Abc1dd23affbc1ee23u3278"));
    System.out.println("Test 5: " + lowestOccurrence("AbcdAbc123123"));
    System.out.print("Test 6: ");
    double calculated = solveEquations(3.4, new String[] {"x*x", "x-10/2.2", "x+4-10", "x+5*8"});
    System.out.println("calculated = " + calculated);

    double calculated1 = solveEquations(1.5, new String[] {"x*2", "x+10/2", "x*1.5-6"});
    System.out.println("calculated1 = " + calculated1);
  }
}
