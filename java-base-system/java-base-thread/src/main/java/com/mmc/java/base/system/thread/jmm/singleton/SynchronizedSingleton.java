// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: SynchronizedSingleton<br/>
 * Description: synchronize 同步 单利模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SynchronizedSingleton {

	private static SynchronizedSingleton instance;
	
	private SynchronizedSingleton() {
		
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static synchronized SynchronizedSingleton getInstance() {
		if (instance == null) {
			instance = new SynchronizedSingleton();
		}
		return instance;
	}
	
	static class SingletonThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getId() +" >>> " + SynchronizedSingleton.getInstance());
		}
		
	}
	
	public static void main(String[] args) {
		int nThreads = 10;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		SingletonThread safeThread = new SingletonThread();
		for (int i = 0; i < nThreads; i++) {
			es.execute(safeThread);
		}
		es.shutdown();
	}
}
