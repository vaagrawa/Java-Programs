package com.cloudwick.java.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Thread> ThreadList = new ArrayList<>();
		for (int i = 1; i < 500; i++) {
			CounterThread obj = new CounterThread(123456 + i);
			obj.setName("Cloud" + i);
			if (i > 50 && i < 101) {
				obj.setPriority(Thread.MIN_PRIORITY);
			}
			obj.start();
			ThreadList.add(obj);
		}
		int running = 0;
		do {
			running = 0;
			for (Thread thread : ThreadList) {
				if (thread.isAlive()) {
					running++;
				}
			}
		} while (running != 0);
		System.out.println("all threads created");
	}

}
