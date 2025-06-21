package com.project.practice.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PracticeThread {
	

	public static void main(String[] args) throws InterruptedException {
		
		InitThread obj = new InitThread();
		
		long start = System.currentTimeMillis();
		
		obj.start();
		
		System.out.println("Start Time: "+ start + " ms \n");
		
//		System.out.println("Putting the Thread to Waiting");
//		obj.wait(4000);
		
//		long duration = System.currentTimeMillis() - start;
//		System.out.println("Sequential Time: "+ duration + " ms \n");
//		
//		obj.stop();
		
//		InitThread obj2 = new InitThread();
//		
//		obj2.start();
//		
//		System.out.println("Putting the Thread to Waiting");
//		obj2.wait(4000);
//		
//		duration = System.currentTimeMillis() - start;
//		System.out.println("Sequential Time: "+ duration + " ms \n");
//		
//		obj2.stop();
		
		new Thread(new AnotherInitThread()).start();
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration Time: "+ duration + " ms \n");
		
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		scheduler.schedule(() -> System.out.println("Task executed after 5 second delay !"), 
				5, 
				TimeUnit.SECONDS);
		scheduler.shutdown();
		
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
		
		schedule.scheduleAtFixedRate(
				() -> System.out.println("Task executed after every 2 second delay !"),
				2,
				2, 
				TimeUnit.SECONDS);
		
		schedule.schedule(
				() -> {
					System.out.println("Initiating shutdown...");
					schedule.shutdown();
				}, 20, TimeUnit.SECONDS);
		
		
		Executors.newCachedThreadPool();
		
		
	}

}
