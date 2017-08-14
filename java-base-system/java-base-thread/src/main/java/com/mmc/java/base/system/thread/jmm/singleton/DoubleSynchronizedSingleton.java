// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: DoubleSynchronizedSingleton<br/>
 * Description: 双重验证加锁优化单利模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DoubleSynchronizedSingleton {

	private static DoubleSynchronizedSingleton instance;
	
	private DoubleSynchronizedSingleton() {
		
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static DoubleSynchronizedSingleton getInstance() {
		if (instance == null) {
			synchronized(DoubleSynchronizedSingleton.class) {
				if (instance == null) {
					instance = new DoubleSynchronizedSingleton();
				}
			}
		}
		return instance;
	}
	
	static class SingletonThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getId() +" >>> " + DoubleSynchronizedSingleton.getInstance());
		}
		
	}
	
	public static void main(String[] args) {
		int nThreads = 100;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		SingletonThread safeThread = new SingletonThread();
		for (int i = 0; i < nThreads; i++) {
			es.execute(safeThread);
		}
		es.shutdown();
	}
}
