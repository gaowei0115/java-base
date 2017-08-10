// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.volatil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * ClassName: NoVolatileThread<br/>
 * Description: 非Volatile 修饰变量<br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class NoVolatileThread extends Thread {

	// 非volatile修饰变量
	private boolean stop = false;
	
	public void subStop() {
		stop = true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		int i = 0;
		while (!stop) {
			System.out.println(Thread.currentThread().getName() + " :: " + i++);
		}
		System.out.println(Thread.currentThread().getName() + " >>> Thread stop");
	}
	
	public static void main(String[] args) throws Exception {
		NoVolatileThread noVolatileThread = new NoVolatileThread();
		int tThreads = 100;
		ExecutorService executor = Executors.newFixedThreadPool(100);
		for (int i = 0; i < tThreads; i++) {
			executor.execute(noVolatileThread);
		}
		noVolatileThread.subStop();
		
		executor.shutdown();
	}
}
