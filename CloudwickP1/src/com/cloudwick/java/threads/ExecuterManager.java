package com.cloudwick.java.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 500; i++) {
			CounterThread obj = new CounterThread(1230256 + i);
			exService.execute(obj);
		}
		exService.shutdown();// Shuts down the resources and services after all
								// the threads are done.Also points thepoint
								// whence no more applications are accepted.
		do {

		} while (!(exService.isTerminated()));// Checks whether all the
												// applications sent to the
												// executor are done
		System.out.println("All threads Done :)");
	}

}
