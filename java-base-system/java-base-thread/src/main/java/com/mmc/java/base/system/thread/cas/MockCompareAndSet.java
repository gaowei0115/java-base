// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/** 
 * className: MockCompareAndSet<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月11日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MockCompareAndSet {

	
	private volatile AtomicBoolean lock = new AtomicBoolean(false);
	
	
	public void setLock(boolean isLock) {
		lock.getAndSet(isLock);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public boolean lock() {
		if (lock.compareAndSet(false, true)) {
			return true;
		}
		return false;
	}
	
	/**
	 * className: BooleanThread<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月11日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class BooleanThread implements Runnable {

		private MockCompareAndSet compareAndSet;
		
		/**
		 * @param compareAndSet
		 */
		public BooleanThread(MockCompareAndSet compareAndSet) {
			this.compareAndSet = compareAndSet;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getName() + ">>>>>" + compareAndSet.lock());
		}
		
	}
	
	public static void main(String[] args) {
		MockCompareAndSet andSet = new MockCompareAndSet();
		BooleanThread booleanThread = new BooleanThread(andSet);
		int nThreads = 10;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(booleanThread);
			if (i == 4) {
				andSet.setLock(true);
			}
		}
		es.shutdown();
	}
}
