package com.project.practice.sealed;

public sealed interface PaymentMethod permits CreditCard, PayPal {
	
	void processPayment(double amount);

}
