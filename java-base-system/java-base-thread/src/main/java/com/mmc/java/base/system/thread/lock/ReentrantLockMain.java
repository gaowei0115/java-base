// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/** 
 * className: ReentrantLockMain<br/>
 * Description: 重入锁<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月26日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ReentrantLockMain {

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	private static Runnable createTaskLock() {
		final ReentrantLock lock = new ReentrantLock();
		return new Runnable() {
			public void run() {
				while (true) {
					try {
						lock.lock();
						 System.out.println("locked " + Thread.currentThread().getName());
						 Thread.sleep(1000);
					} catch (Exception e) {
//						e.printStackTrace();
						System.out.println(Thread.currentThread().getName() + " is interrupt");
					} finally {
						lock.unlock();
					}
				}
			}
		};
	}
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(createTaskLock(), "firstThread");
		Thread thread2 = new Thread(createTaskLock(), "secondThread");
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.interrupt(); // 中断线程
//		System.out.println(Thread.interrupted());
		System.out.println(thread2.isInterrupted());
	}
}
