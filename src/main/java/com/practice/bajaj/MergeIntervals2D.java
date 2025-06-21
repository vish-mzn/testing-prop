package com.practice.bajaj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals2D {
	
	/*
	 * Problem: Given an array of intervals [[start1, end1], [start2, end2], ...], 
	 * merge all overlapping intervals and return the result.
	 * 
	 * 
	 * Approach:
	 * 1. Sort intervals by start.
	 * 2. Compare each interval with the last merged one.
	 * 3. Merge if overlapping (curr.start <= prev.end), else add new.
	 * 
	 */
	private static int[][] merge(int[][] intervals) {
		
		if (intervals.length <= 1) return intervals;
		
		// Step 1: Sort by start time
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		
		List<int[]> merged = new ArrayList<>();
		
		int[] current = intervals[0];
		
		for (int i=1; i<intervals.length; i++) {
			int[] next = intervals[i];
			
			if (next[0] <= current[1]) {			// this is the condition to check for overlapping or not
				// Merge overlapping
				current[1] = Math.max(current[1], next[1]);
			}
			else {
				merged.add(current);				// this condition is just for the rollback situation
				current = next;
			}
		}
		merged.add(current);
		
		return merged.toArray(new int[merged.size()][]);
	}
	

	public static void main(String[] args) {
		
		int[][] input = new int[][] { {1,3}, {2,6}, {8,10}, {15,18} };
		
		System.out.println(Arrays.deepToString(input));
		
		System.out.println(Arrays.deepToString(merge(input)));
	}

}
