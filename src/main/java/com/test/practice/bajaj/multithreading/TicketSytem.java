package com.test.practice.bajaj.multithreading;

public class TicketSytem implements Runnable {
	
	public static Thread mainThread;
	public static TicketSytem ticketSystem;
	

	public static void main(String[] args) {
		ticketSystem = new TicketSytem(); 
		
		mainThread = new Thread(ticketSystem);
		
		System.out.println("State after creating mainThread: "+ mainThread.getState());
		
		mainThread.start();
		
		System.out.println("State after starting mainThread: "+ mainThread.getState());
	}

	@Override
	public void run() {
		
		TicketBooking booking = new TicketBooking();
		Thread bookingThread  = new Thread(booking); // just created | state == NEW
		
		System.out.println("State after creating bookingThread: "+ bookingThread.getState());
		
		bookingThread.start(); // after starting | state == RUNNABLE
		
		System.out.println("State after starting bookingThread: "+ bookingThread.getState());
		
		try {
			Thread.sleep(200);  // put to sleep | state == TIMED_WAITING
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("State after sleeping bookingThread: "+ bookingThread.getState());
		
		try {
			// Moves mainThread to waiting state 
			
			bookingThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("State after bookingThread finishes: "+ bookingThread.getState());
		
	}

}
