// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi.sleep;

import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: SleepThread<br/>
 * Description: sleep方法测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SleepThread implements Runnable {

	private final AtomicInteger act = new AtomicInteger(0);
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		executor();
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public synchronized void executor() {
		System.out.println(Thread.currentThread().getName() + " begin executor.....");
		System.out.println(Thread.currentThread().getName() + " 是否 sleep 2s");
		try {
			if (act.incrementAndGet() == 1) {
				System.out.println(Thread.currentThread().getName() + " 是");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end executor......");
	}
}
