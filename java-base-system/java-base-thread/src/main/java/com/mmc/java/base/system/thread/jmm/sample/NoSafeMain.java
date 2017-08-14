// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: NoSafeMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class NoSafeMain {

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		NoSafeThread noSafeThread = new NoSafeThread();
		int nThreads = 10;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(noSafeThread);
		}
		es.shutdown();
		System.out.println(noSafeThread.getState());
	}
}
