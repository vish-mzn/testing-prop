package com.project.practice.sealed;

public class Main {

	public static void main(String[] args) {
		PaymentMethod pm = new CreditCard("1234-5678-9876-5432");
		
		// enhanced switch (Java 17+)
//		switch (pm) {
//	    	case CreditCard cc -> System.out.println("Credit card: " + cc.number());
//	    	case PayPal pp -> System.out.println("PayPal: " + pp.email());
	    	// No default needed (exhaustive)
//		}

	}

}
