// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi;

/** 
 * className: WaitApiThread<br/>
 * Description: Wait阻塞方法测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class WaitApiThread {

	
	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				synchronized(lock) {
					System.out.println(Thread.currentThread().getId() + " first running");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId() + " first end");
				}
			}
		});
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getId() + " second running");
				
				System.out.println(Thread.currentThread().getId() + " second end");
			}
		});
		
		t.start();
		t1.start();
		synchronized(lock) {
			lock.notifyAll();
		}
	}
}
