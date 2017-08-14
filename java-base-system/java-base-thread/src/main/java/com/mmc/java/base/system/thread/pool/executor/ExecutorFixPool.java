// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.pool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: ExecutorFixPool<br/>
 * Description: 固定线程池测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ExecutorFixPool {
	
	static class FixThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getId() + " >>>> ..");
		}
	} 

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		FixThread fixThread = new FixThread();
		for (int i = 0; i < 12; i++) {
			es.execute(fixThread);
		}
		es.shutdown();
	}
}
