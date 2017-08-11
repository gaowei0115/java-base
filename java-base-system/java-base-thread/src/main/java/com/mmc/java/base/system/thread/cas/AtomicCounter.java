// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: AtomicCounter<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月11日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AtomicCounter implements Runnable {

	private AtomicInteger counter = new AtomicInteger(0);
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			
		}
		System.out.println(Thread.currentThread().getName() + " >>>> ");
		counter.incrementAndGet();
	}
	
	public static void main(String[] args) throws Exception {
		AtomicCounter atomicCounter = new AtomicCounter();
		int nThreads = 1000;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(atomicCounter);
		}
		es.shutdown();
		es.execute(atomicCounter);
//		Thread.sleep(1000);
		System.out.println(atomicCounter.counter.get());
	}

}
