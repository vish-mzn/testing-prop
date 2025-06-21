package com.project.work.javastream;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*; 

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SapientQuest {

    static class Employee {
    
        public int id;
        public String name;
        public String dept;
        public int salary;

        public Employee() {}

        public Employee(int id, String name, String dept, int salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getDept() {
            return this.dept;
        }

        public int getSalary() {
            return this.salary;
        }

        @Override
		public String toString() {
			return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
		}
    }

    public static void main(String[] args) {

        // Sample Employee List
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "HR", 60000),
            new Employee(2, "Jane", "Finance", 45000),
            new Employee(3, "Mike", "HR", 75000),
            new Employee(4, "Sarah", "Finance", 30000));

        // 1. Find Employees Earning More Than 50,000
        List<Employee> result1 = employees.stream()
                                    .filter(e -> e.getSalary() > 50000)
                                    .collect(Collectors.toList());

        System.out.println(result1);
       
        // 2. Group Employees by Department
        Map<String, List<Employee>> result2 = employees.stream()
                                    .collect(Collectors.groupingBy(
                                        e -> e.getDept(),
                                        Collectors.toList()
                                    ));
        System.out.println(result2);
       
        // 3. Find the Employee with the 3rd Highest Salary
        Optional<Employee> result3 = employees.stream()
                        .sorted(Comparator.comparingInt((Employee e) -> e.getSalary()).reversed())
                        .skip(2)
                        .findFirst();
        System.out.println(result3);

       
        // 4. Sort Employees by Name
        List<Employee> result4 = employees.stream()
                                    .sorted(Comparator.comparing(e -> e.getName()))
                                    .collect(Collectors.toList());
        System.out.println(result4);
    }

    

}