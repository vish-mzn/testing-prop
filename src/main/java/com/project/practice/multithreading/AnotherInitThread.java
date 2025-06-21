package com.project.practice.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AnotherInitThread implements Runnable, Callable<Integer> {

	@Override
	public void run() {
		System.out.println("Thread running using Runnable Interface");
		System.out.println("Processing in Thread name: " +Thread.currentThread().getName());
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
//	Executor
	
		

}
