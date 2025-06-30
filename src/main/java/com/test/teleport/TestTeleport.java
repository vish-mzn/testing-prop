package com.test.teleport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestTeleport {
	
/*
 * Q1: Employee Class
 * 		Fields
 * 			Name
 * 			Age
 * 			Salary
 * 
 * Sort Employees List by Name. If names are same, sort by age.
 * 
 * 
 * 
 * 
 * The meeting schedule is about to end.
Action Items for this meeting:
• Change the order of age to descending in the assignment given by Balakrishnan. ~Vishesh Pahuja
 
• Vishesh Pahuja to practice SQL queries, specifically focusing on sorting and ordering by age in descending order. ~Vishesh Pahuja
 
• Prepare and solve 50 to 100 questions related to Java Core, Java 8 problems, and Spring Boot questions. ~Vishesh Pahuja
 *
 */
	
	static class Employee {
		
		private String name;
		
		private int age;
		
		private Double salary;

		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(String name, int age, Double salary) {
			super();
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
		
	}
	
	
	private static List<TestTeleport.Employee> sortEmployee(List<TestTeleport.Employee> input) {
		
		List<TestTeleport.Employee> output = input.stream()
												.sorted(Comparator.comparing(Employee::getName)
														.thenComparing(Comparator.comparing(Employee::getAge)))
												.collect(Collectors.toList());
		
		
		return output;
	}
	

	public static void main(String[] args) {
		
		List<TestTeleport.Employee> list = new ArrayList<>();
		list.add(new Employee("Bala", 30, 3000.0));
		list.add(new Employee("Arpan", 28, 3000.0));
		list.add(new Employee("Girish", 32, 3000.0));
		list.add(new Employee("Bala", 28, 3000.0));
		list.add(new Employee("Vishesh", 30, 3000.0));
		
		System.out.println("Unsorted Employees:  "+ list + "\n");
		
		System.out.println("Sorted Employes:  " + sortEmployee(list));
		
		HashMap<K, V>

	}

}
