// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * ClassName: AuthoTheadMain<br/>
 * Description: 自定义线程池测试<br/>
 * Author: GW<br/>
 * Create： 2017年7月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class AuthoTheadMain {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			new Thread(new MyThread()).start();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("普通执行 cost time " + (end - start) + " ms");
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ThreadPool.instance().execute(new MyThread());
			try {
//				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			ThreadPool.instance().shutDown();
		}
		end = System.currentTimeMillis();
		System.out.println("自定义线程池执行 cost time " + (end - start) + " ms");
		
		start = System.currentTimeMillis();
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10000; i++) {
			executorService.execute(new MyThread());
		}
		
		end = System.currentTimeMillis();
		System.out.println("Executor线程池执行 cost time " + (end - start) + " ms");
		
	}
	
	/**
	 * ClassName: MyThread<br/>
	 * Description: 测试线程<br/>
	 * Author: GW<br/>
	 * Create： 2017年7月22日<br/>
	 *
	 * History: (Version) Author dateTime description <br/>
	 */
	static class MyThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
