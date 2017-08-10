// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.volatil;

/** 
 * ClassName: VolatileThread<br/>
 * Description: Volatile 修饰变量示例<br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class VolatileThread implements Runnable {

	// 通过volatile修饰变量确保在多个线程中可见
	private volatile boolean stop = false;
	
	/**
	 * Description：设置线程停止状态<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public void subStop() {
		stop = true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		int i = 0;
		while (!stop) {
			System.out.println(Thread.currentThread().getName() + " ::: " + (i++));
		}
		System.out.println(Thread.currentThread().getName() + " >> Stop Thread");
	}
}
