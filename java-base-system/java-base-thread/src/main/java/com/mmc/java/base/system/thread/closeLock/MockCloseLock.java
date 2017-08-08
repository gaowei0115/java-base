// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.closeLock;

import java.util.concurrent.CountDownLatch;

/** 
 * className: MockCloseLock<br/>
 * Description: 模拟实现闭锁机制<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月2日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MockCloseLock {

	/**
	 * 模拟实现对多线程任务执行时间统计操作
	 */
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param threads
	 * @param task
	 * @return
	 * @throws InterruptedException 
	 */
	public long timeTasks(int threads, final Runnable task) throws InterruptedException {
		final CountDownLatch startDate = new CountDownLatch(1);
		final CountDownLatch endDate = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			Thread t = new Thread() {
				/* (non-Javadoc)
				 * @see java.lang.Thread#run()
				 */
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + " init ....");
						startDate.await(); // 等待初始化完所有待执行任务
						try {
							task.run();
						} finally {
							// 执行完一个任务，endDate递减1
							endDate.countDown();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
		}
		long start = System.nanoTime();
		startDate.countDown();// 控制线程初始化闭锁，递减1，开启闭锁
		System.out.println(Thread.currentThread().getName() + " running ....");
		endDate.await();// 等待所有任务执行完成
		long end = System.nanoTime();
		return end - start;
	}
}
