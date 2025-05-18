package com.project.work;

public class A403_PalindromeCheck_Practice {

	/*
	 * Q. Finding the Palindrome using Java
	 * 
	 * find the Palindrome <String>
	 * 
	 * find the Palindrome <Integer>
	 * 
	 * NOTE : negative numbers are not palindrome
	 * 
	 */
	public static void main(String[] args) {
		
		System.out.println("Getting back again on to Java\n");
		
		
		
	}

	public static boolean isPalindromeString(String str) {
		
	    // Write your code here.
	    int i = 0, j = str.length() - 1;
	
	    while (i < j) {
	      if (str.charAt(i) != str.charAt(j)) {
	        return false;
	      }
	      i++;
	      j--;
	    }
	    
	    return true;
	}
	
	
	public static boolean isPalindromeNumber(int num) {
	    
		// Write your code here.
		if (num < 0 || num % 10 == 0) return false;  // negative numbers are not palindrome
			
		int original = num;
		int reverse = 0;	

	    while (num != 0) {
	    	int digit = num % 10;				// get last digit or getting the remainder
	    	reverse = reverse * 10 + digit;		// shift left and add digit
	    	num /= 10;							// remove last digit
	    }
	    
	    return original == reverse;
	}
	
	

}
