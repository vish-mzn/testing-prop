package com.leetcode;

public class Quest1 {

	public static void main(String[] args) {
		
		int arr[] = { 7,1,5,3,6,4 };
//		int arr2[] = { 7,6,4,3,1 };
		
		System.out.println(maxProfit1(arr));
	}
	
	/*
	 * Best time to buy and sell stock I
	 * 
	 * This is Brute Force : O(n) = n(n-1)/2
	 */
	public static int maxProfit(int[] prices) {
		
		int minNumber = 0;
		int maxdifference = 0;
		
		for(int i=0; i<prices.length-1; i++) {
			minNumber = prices[i];
			for(int j=i+1; j<prices.length; j++) {
				
				if((minNumber<prices[j]) && (prices[j]-minNumber > maxdifference)) {
						maxdifference = prices[j]-minNumber;
				}
				
			}
		}
		return maxdifference;
    }
	
	/*
	 * Best time to buy and sell stock I
	 * 
	 * This is One pass : O(n) = n
	 */
	public static int maxProfit1(int[] prices) {
		
		int minNumber = Integer.MAX_VALUE;
		int maxdifference = 0;
		
		for(int i=0; i<prices.length-1; i++) {
			if(prices[i]<minNumber) {
				minNumber = prices[i];
			}
			else if (prices[i]-minNumber > maxdifference) {
				maxdifference = prices[i]-minNumber; 
			}
		}
		return maxdifference;
    }

}
