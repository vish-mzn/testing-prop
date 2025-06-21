package com.test.capgemini;

public abstract class Messge {
	
	public String recipient;
//	public abstract final void sendMessage();
	public static void main(String[] args) {
		Messge m = new TextMessage();

	}
	
	
	static class TextMessage extends Messge {
		public final void sendMessage() {
			System.out.println("Text message to "+recipient);
		}
	}
}
