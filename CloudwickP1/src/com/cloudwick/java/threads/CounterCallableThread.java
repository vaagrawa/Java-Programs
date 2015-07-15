package com.cloudwick.java.threads;

import java.util.concurrent.Callable;

public class CounterCallableThread implements Callable<Long> {

	private int counter;

	public CounterCallableThread(int count) {
		this.counter = count;
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long sum = 0;
		for (int i = 0; i < counter; i++) {
			sum += i;

		}
		System.out.println(Thread.currentThread() + "Value" + sum);
		return sum;
	}
}
