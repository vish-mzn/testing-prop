package com.project.practice.sealed;

public record PayPal(String email) implements PaymentMethod {

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing PayPal: " + email);
	}

}
