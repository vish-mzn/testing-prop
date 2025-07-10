package com.test.practice.bajaj.multithreading;

public class TicketBooking implements Runnable {

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		System.out.println("State of bookingThread while main-Thread is waiting: "+ 
//								Thread.currentThread().getState());
		
		System.out.println("State of bookingThread while main-Thread is waiting: "+ 
								TicketSytem.mainThread.getState());
		
		try {
			
			// Another times waiting
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
