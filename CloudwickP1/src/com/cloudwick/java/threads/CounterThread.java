package com.cloudwick.java.threads;

public class CounterThread extends Thread {

	private int counter;

	public CounterThread(int count) {
		this.counter = count;
	}

	public void run() {
		long sum = 0;
		for (int i = 0; i < counter; i++) {
			sum += i;

		}
		System.out.println(Thread.currentThread() + "Value" + sum);
	}
}
