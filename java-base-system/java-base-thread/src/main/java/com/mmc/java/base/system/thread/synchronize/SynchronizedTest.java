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
		synchronized (Object.class) {
			param++;
		}
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * 
	 * @return
	 */
	public int getParam() {
		synchronized (this) {
			return param;
		}
	}

	// public synchronized void execute() {
	// System.out.println(Thread.currentThread().getId() + "... start");
	// try {
	// System.out.println(Thread.currentThread().getId() + " :: execute");
	// Thread.sleep(1000);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// System.out.println(Thread.currentThread().getId() + "... end");
	// }

	public void execute() {
		synchronized (Object.class) {
			System.out.println(Thread.currentThread().getId() + "... start");
			try {
				System.out.println(Thread.currentThread().getId() + " ::  execute");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId() + "... end");
		}
	}

	/**
	 * Description：静态代码块同步<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public static synchronized void sexecute() {
		System.out.println(Thread.currentThread().getId() + "... start");
		try {
			System.out.println(Thread.currentThread().getId() + " ::  execute");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() + "... end");
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		SynchronizedTest synch = null;
		synch = new SynchronizedTest();
		for (int i = 0; i < 2; i++) {
			// executorService.execute(synch.new SynchroThread(synch));
			executorService.execute(synch.new SynchroThread(synch));
		}

		if (!executorService.isTerminated()) {
			executorService.shutdown();
		}
	}

	class SynchroThread implements Runnable {

		private SynchronizedTest synchronizedTest;

		/**
		 * Construtor(@param synchronizedTest) SynchronizedTest.java
		 */
		public SynchroThread(SynchronizedTest synchronizedTest) {
			this.synchronizedTest = synchronizedTest;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			SynchronizedTest.sexecute();
		}
	}
}
