// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi.wait;

import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: WaitThread<br/>
 * Description: wait等待方法测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class WaitThread implements Runnable {
	
	private final AtomicInteger act = new AtomicInteger(0);

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		exector();
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public synchronized void exector() {
		System.out.println(Thread.currentThread().getName() + " before running");
		System.out.println(Thread.currentThread().getName() + " 是否 waiting");
		try {
			if (act.incrementAndGet() == 1) {
				System.out.println(Thread.currentThread().getName() + "是");
				wait(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end running");
	}
}
