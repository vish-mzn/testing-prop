package com.test.capgemini;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestIris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str = "Java Concept";
		
		String[] strAr = str.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for (String s :strAr) {
			
			char arr[] = s.toCharArray();
			List<String> list = new ArrayList<>();
			
			for (char c : arr) {
				list.add(String.valueOf(c));
			}
			
			Integer sz = list.size();
			
			String newobj = IntStream.range(0, list.size())
				.mapToObj(i -> list.get(sz-1-i))
				.collect(Collectors.joining());
			
			sb.append(newobj + " ");
		}
		
		System.out.println(sb.toString().trim());
		
	}

}
