// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: AtomicFutureCounter<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月11日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AtomicFutureCounter implements Callable<String> {

	private AtomicInteger counter = new AtomicInteger(0);
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() throws Exception {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			
		}
		counter.incrementAndGet();
		return "success";
	}
	
	public static void main(String[] args) {
		AtomicFutureCounter atomicFutureCounter = new AtomicFutureCounter();
		int nThreads = 100;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		List<Future<String>> result = new ArrayList<Future<String>>();
		for (int i = 0; i < nThreads; i++) {
			Future<String> r = es.submit(atomicFutureCounter);
			result.add(r);
		}
		es.shutdown();
		for (Future<String> f : result) {
			try {
				f.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(atomicFutureCounter.counter);
	}

}
