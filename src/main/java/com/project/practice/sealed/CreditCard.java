package com.project.practice.sealed;

public record CreditCard(String number) implements PaymentMethod {

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing credit card: " + number);
	}

}
