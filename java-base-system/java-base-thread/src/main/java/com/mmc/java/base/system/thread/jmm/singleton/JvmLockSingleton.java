// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: JvmLockSingleton<br/>
 * Description: JVM加载时自身锁控制 -- 单利模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class JvmLockSingleton {

	private JvmLockSingleton() {
		
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static JvmLockSingleton getInstance() {
		return JvmLockSingletonLock.instance;
	}
	
	/**
	 * className: JvmLockSingletonLock<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月14日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class JvmLockSingletonLock {
		public static JvmLockSingleton instance = new JvmLockSingleton();
	}
	
	
	static class SingletonThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getId() +" >>> " + JvmLockSingleton.getInstance());
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
