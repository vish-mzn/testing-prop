package com.project.practice.multithreading;

public class InitThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread running using THREAD class");
		System.out.println("Processing in Thread name: " +Thread.currentThread().getName());
	}
	
}
