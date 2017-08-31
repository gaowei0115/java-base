// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.closeLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: CountDownLatchMock<br/>
 * Description: CountDownLatch闭锁<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class CountDownLatchMock {

	private static final CountDownLatch countDown = new CountDownLatch(10);
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatchThread t = new CountDownLatchThread();
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			es.execute(t);
		}
		System.out.println("所有工作准备完毕....");
		Thread.sleep(5000);
		System.out.println("开始执行....");
		for (int i = 0; i < 10; i++) {
			countDown.countDown();
		}
		es.shutdown();
		System.out.println("结束执行任务......");
	}
	
	static class CountDownLatchThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				try {
					countDown.await();
					System.out.println(Thread.currentThread().getName() + " running");
				} catch (InterruptedException e) {
				}
			} finally {
				
			}
		}
		
	}
	
	
}
