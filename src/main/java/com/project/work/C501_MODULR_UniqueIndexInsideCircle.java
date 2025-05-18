package com.project.work;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C501_MODULR_UniqueIndexInsideCircle {

	/*
	 * Q. Write a function:
	 * 
	 * To find the Unique coordinates in a circle
	 * 
	 */
	public static int findUniqueCoordinates(String S, int[] X, int[] Y) {
		int uniqueCoordinates = 0;
		
		Map<String, Integer> coordinateMap = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();
		
		int length = S.length();
		
		char[] arr = S.toCharArray();
		
		for (int i=0; i<length; i++) {
			
			String tag = String.valueOf(arr[i]); 	// tag for each coordinate
			int distance = X[i]*X[i] + Y[i]*Y[i];	// distance from origin
			
			
			if (!coordinateMap.containsKey(tag)) {
//				System.err.println("Tag----"+tag);
//				System.err.println("Distance----"+distance);
				coordinateMap.put(tag, distance);
			}
		}
		
		Set<Integer> seenValues = new HashSet<>();
		
		for(Map.Entry<String, Integer> entry : coordinateMap.entrySet()) {
			if(seenValues.contains(entry.getValue())){
				countMap.values().removeIf(v -> v.equals(entry.getValue()));
			} else {
				seenValues.add(entry.getValue());
				countMap.put(entry.getKey(), entry.getValue());
			}
		}
		uniqueCoordinates = countMap.size();
		return uniqueCoordinates;
	}
	
	
	
	
	public static void main(String[] args) {
		String S = "ABCDA";
		int[] X = {1,2,3,-1,2};
		int[] Y = {2,-2,1,3,4};
		
		System.out.println("Output 1 ------------" + findUniqueCoordinates(S, X, Y));
		
		String T = "BBCDA";
		int[] A = {2,1,3,-4,5};
		int[] B = {2,-2,1,3,5};
		
		System.out.println("Output 2 ------------" + findUniqueCoordinates(T, A, B));
		
		String U = "AAC";
		int[] C = {1,2,2};
		int[] D = {2,-2,1};
		
		System.out.println("Output 3 ------------" + findUniqueCoordinates(U, C, D));
	}
	
	
}
