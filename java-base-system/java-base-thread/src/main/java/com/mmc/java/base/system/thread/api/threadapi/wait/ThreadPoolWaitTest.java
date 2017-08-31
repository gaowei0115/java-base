// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: ThreadPoolWaitTest<br/>
 * Description: wait测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ThreadPoolWaitTest {

	public static void main(String[] args) {
		WaitThread t = new WaitThread();
		int nThreads = 10;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(t);
		}
		es.shutdown();
	}
}
