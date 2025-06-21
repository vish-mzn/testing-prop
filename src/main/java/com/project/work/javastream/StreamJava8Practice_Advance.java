package com.project.work.javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		
		public Employee(String name, String dept, double salary) {
			super();
			this.name = name;
			this.dept = dept;
			this.salary = salary;
		}
		
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

		@Override
		public String toString() {
			return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
		}

	}
	
	
	
	public static void main(String[] args) {
		// 
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(new Employee("Jasmine", "ECE", 8000.00));
		employeeList.add(new Employee("YanKen", "MECH", 8000.00));
		employeeList.add(new Employee("ThaiHau", "ECE", 30000.00));
		employeeList.add(new Employee("Vishesh", "MECH", 6000.00));
		employeeList.add(new Employee("Zairee", "EE", 4000.00));
		
		
		// Group employees by department
		Map<String, List<String>> departmentGrouped = employeeList.stream()
				.collect(Collectors.groupingBy(
					Employee::getDept, 
					Collectors.mapping(Employee::getName, Collectors.toList())
				));
		
		System.out.println("Grouped employees based on department: \n"+ departmentGrouped +"\n");
		
		
		// Sorting employee name based on salary order 
		List<String> sortedListSalaryBase = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		
		System.out.println("Sorted Employees on Salary:  " + sortedListSalaryBase + "\n");
		
		
		// Group employees by department and finding the average salary
		Map<String, Double> deptAvgSaList = employeeList.stream()
				.collect(Collectors.groupingBy(
					Employee::getDept, 
					Collectors.averagingDouble(Employee::getSalary))
				);
		
		System.out.println("Dept averaged Salary:  " + deptAvgSaList + "\n");
		
		
		// Finding out the second highest salary
		// distinct elements, sorted in reverse order, skipped first element, picked the first element [findFirst()] in the end  
		Optional<Double> secondHighestSalary = employeeList.stream()
				.map(Employee::getSalary)
				.distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst();
		
		System.out.println("Second highest salary:  " + secondHighestSalary + "\n");
		
		
		// Finding the distinct salaries
		List<Double> distinctSalaries = employeeList.stream()
				.map(Employee::getSalary)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Distinct salaries:  " + distinctSalaries + "\n");
		
		
		
		// Employee with min salary
		employeeList.stream()
				.min(Comparator.comparingDouble(Employee::getSalary))
				.ifPresent(employee -> System.out.println("Min salary:: "+ employee.getSalary() + "\n"));
		
		
		
		// Department wise employee count
		Map<String, Long> resultMap = employeeList.stream()
				.collect(Collectors.groupingBy(
						Employee::getDept,
						Collectors.counting()));
		System.out.println("Department wise employee count:  " + resultMap + "\n");
		
		
		
		// Those employees whose department is 'MECH'
		List<String> mechEmployees = employeeList.stream()
				.filter(e -> e.getDept().equals("MECH"))
				.map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println("Employee whose department is 'MECH': " + mechEmployees + "\n");
		
		
		// Sort Employees by Name
		List<Employee> sortedEmployeeNameWise = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		
		System.out.println("Name wise sorted Employees: " + sortedEmployeeNameWise + "\n");
		
	}

}
