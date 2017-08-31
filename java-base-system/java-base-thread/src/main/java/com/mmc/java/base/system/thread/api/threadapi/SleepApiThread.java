// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi;

/** 
 * className: SleepApiThread<br/>
 * Description: sleep休眠方法测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SleepApiThread {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getId() + " running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getId() + " end");
			}
		});
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getId() + " running");
				System.out.println(Thread.currentThread().getId() + " end");
			}
		});
		
		t.start();
		t1.start();
	}
}
