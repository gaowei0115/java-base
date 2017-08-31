// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: ThreadPoolSleepTest<br/>
 * Description: 多线程测试sleep<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ThreadPoolSleepTest {

	public static void main(String[] args) {
		SleepThread st = new SleepThread();
		int nThreads = 10;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(st);
		}
		es.shutdown();
	}
}
