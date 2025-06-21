package com.test.capgemini;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

public class Testingwithagam {
	
//	private Testingwithagam singleton = new Testingwithagam();
//	
//	private Testingwithagam() {
//		
//	}
//	
//	synchronized Testingwithagam getInstance() {
//		if (singleton == null) {
//			return singleton;
//		}
//		return null;
//	}
	
	
	/*
	 * Find the frequency of each character in the list of string
	 * apple, cherry, mango
	 * 
	 */
	private static List<Integer> characterCount(List<String> input) {
		List<Integer> output = input.stream()
				.map(s -> s.length())
				.collect(Collectors.toList());
		
		return output;
		
	}

	public static void main(String[] args) {
		
		List<String> input = List.of("Apple", "Cherry");
		
		List<Integer> output = characterCount(input);
		
		System.out.println(output);
		
	}
	
//	
//	@Entity
//	@Table(name = "")
//	public static class Foo {
//		
//		@Id
//		@Generated(GenertionType.SEQUENtIAL/IDENTIy)
//		@Column(nullable = true, length = 32)
//		
//		@ManyToOne
//		
//		@OneToMany
//		
//		
//	}

}
