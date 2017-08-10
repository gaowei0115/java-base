// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.volatil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * ClassName: VolatileMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class VolatileMain {

	public static void main(String[] args) throws Exception {
		VolatileThread volatileThread = new VolatileThread();
		
		
		int tThreads = 100;
		ExecutorService executor = Executors.newFixedThreadPool(100);
		for (int i = 0; i < tThreads; i++) {
			executor.execute(volatileThread);
		}
		volatileThread.subStop();
		
		executor.shutdown();
	}
}
