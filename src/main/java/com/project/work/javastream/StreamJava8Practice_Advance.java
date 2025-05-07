package com.project.work.javastream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamJava8Practice_Advance {
	
	
	
	
	/*
	 * remove duplicate elements and sort the list
	 * 
	 */
	private static List<Integer> removeDuplicates(List<Integer> numbers) {
		List<Integer> filtererd = numbers.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		return filtererd;
	}
	
	
	
	
	
	static class Employee {
		
		private String name;
		private String dept;
		private double salary;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// Filtering remove duplicate elements and sort the list
		List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 3, 6, 6, 5, 12);
		System.out.println("Input List: " +inputNumbers);
		System.out.println("Remove duplicates and sort the list: " +removeDuplicates(inputNumbers)+"\n");
		// Output: 
		
		
		
	}

}
