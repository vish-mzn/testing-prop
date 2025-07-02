package com.java.eight;

import java.util.Arrays;

public class RunningSum1DArray {
	
	public static void main(String[] args) {

		int[] nums = {1,1,1,1,1,1};

		System.out.println(Arrays.toString(runningSum(nums)));
//		int[] nums = {1,2,3,4,5,6,7};
//        int[] result = new int[nums.length];
//        
//        int runningSum = 0;
//        
//        for (int i=0; i<nums.length; i++) {
//            runningSum = runningSum + nums[i];
//            System.out.println(runningSum);
//        }
	}

	static int[] runningSum(int[] nums) {
		int[] result = new int[nums.length];
		int count = 0;

		for (int i=0; i<nums.length; i++) {
			count = count + nums[i];
			result[i] = count;
//			System.out.println(count);
		}
		return result;
	}

}
