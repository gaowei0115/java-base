// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.volatil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: NoSafeVolatileMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class NoSafeVolatileMain {

	public static void main(String[] args) {
		NoSafeVolatileThread noSafeVolatileThread = new NoSafeVolatileThread();
		
		int nThreads = 100;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(noSafeVolatileThread);
		}
		es.shutdown();
		System.out.println(noSafeVolatileThread.getState());
	}
}
