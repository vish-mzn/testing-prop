package com.project.work.javastream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMphasis {

	public static void main(String[] args) {
		
		//Assignment - Find top 3 words present in map based on their highest associated value

		//Output: JPA, DotNet, React
		Map<String, Integer> map = new HashMap<>();
		map.put("Java", 35);
		map.put("JPA", 45);
		map.put("Angular", 20);
		map.put("React", 41);
		map.put("DotNet", 42);
		
		List<String> top3Words = map.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.limit(3)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(top3Words);
		
		
		List<Integer> top3Values = map.values().stream()
				.sorted(Comparator.reverseOrder())
				.limit(3)
				.collect(Collectors.toList());
		
		List<String> top3Keys = new ArrayList<>();
		
		for (Integer i : top3Values) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue().equals(i)) {
					top3Keys.add(entry.getKey());
				}
			}
		}
		System.out.println(top3Keys);

	}

}
