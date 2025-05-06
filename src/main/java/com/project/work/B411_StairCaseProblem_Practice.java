package com.project.work;

public class B411_StairCaseProblem_Practice {

	/*
	 * Q. Write a function:
	 * 
	 * StairCase Problem (Dynamic Programming)
	 * 
	 * You are climbing a staircase. It takes (n) steps to reach the top.
	 * Each time you can either climb 1 step or 2 steps.
	 * In how many distinct ways can you reach the top of the staircase?
	 * 
	 * Example:
	 * If you have 3 steps:
	 * You can climb 1 step + 1 step + 1 step
	 * Or you can climb 1 step + 2 steps
	 * Or you can climb 2 steps + 1 step
	 * Thus, there are 3 distinct ways to reach the top.
	 * 
	 * Approach:
	 * The number of ways to reach the n-th step is the sum of the number of ways to reach the (n-1)-th step and the (n-2)-th step.
	 * This is because from any step i, you can reach step i+1 or i+2.
	 * 
	 * Recurrence relation:
	 * ways(n) = ways(n-1) + ways(n-2)
	 * 
	 * Base cases:
	 * ways(0) = 1 (There is one way to stay at the ground level, doing nothing)
	 * 
	 * ways(1) = 1 (There is only one way to reach the first step)
	 * 
	 */
	private static int countWays(int n) {
		int ways = 1;
		
		if (n==0 || n==1) {
			return 1;
		}
		
		int[] dp = new int[n+1]; // we are taking the size to (n+1) because starting from ground/arr[0] 0'th step. 
		dp[0] = 1;
		dp[1] = 1;
		
		// this for loop is the only logic to find the number of ways to reach to the TOP. 
		for (int i = 2; i <= n; i++) {
			dp [i] = dp[i-1] + dp[i-2];
		}
		ways = dp[n]; // the last element of the defined array is the total=count of numberOfWays.
		
		return ways;
	}
	
	
	public static void main(String[] args) {
		int n = 4; // number of steps
		
		System.out.println("Number of ways to reach "+ n +" STEP--- "+ countWays(n));
	}
	
	
}
