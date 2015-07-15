package com.cloudwick.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableManager {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		List<Future> dataList = new ArrayList<Future>();
		
		ExecutorService exService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 500; i++) {
			CounterCallableThread obj = new CounterCallableThread(1230256 + i);
			Future <Long> val =	exService.submit(obj);
			dataList.add(val);
		}
		
		 exService.shutdown();// Shuts down the resources and services after all
			// the threads are done.Also points thepoint
			// whence no more applications are accepted.
		for(Future data: dataList){
			System.out.println(data.get());
		}
		do {

		} while (!(exService.isTerminated()));// Checks whether all the
												// applications sent to the
												// executor are done
		
	
		System.out.println("All threads Done :)");
	}

}
