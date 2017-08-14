// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: ExecutorCachePool<br/>
 * Description: 缓存线程池实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ExecutorCachePool {

	static class ExecutorCacheThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getId() + " >>");
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		ExecutorCacheThread cacheThread = new ExecutorCacheThread();
		for (int i = 0; i < 100; i++) {
			es.execute(cacheThread);
		}
		es.shutdown();
	}
}
