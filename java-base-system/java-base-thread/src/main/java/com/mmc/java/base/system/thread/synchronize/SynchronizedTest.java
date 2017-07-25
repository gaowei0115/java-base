// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * ClassName: SynchronizedTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月25日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SynchronizedTest {

	private static int param;
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public void setParam() {
		synchronized(Object.class) {
			param++;
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public int getParam() {
//		synchronized(Object.class) {
			return param;
//		}
	}
	
	public static void main(String[] args) {
		final SynchronizedTest synch1 = new SynchronizedTest();
		final SynchronizedTest synch2 = new SynchronizedTest();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		SynchronizedTest synch = null;
		for (int i = 0; i < 10; i++) {
			synch = new SynchronizedTest();
			executorService.execute(synch.new SynchroThread(synch));
		}
	}
	
	class SynchroThread implements Runnable {

		
		private SynchronizedTest synchronizedTest;
		
		/**
		 * Construtor(@param synchronizedTest)
		 * SynchronizedTest.java
		 */
		public SynchroThread(SynchronizedTest synchronizedTest) {
			this.synchronizedTest = synchronizedTest;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			synchronizedTest.setParam();
			System.out.println(Thread.currentThread().getId() + " synch1 :: " + synchronizedTest.getParam());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
