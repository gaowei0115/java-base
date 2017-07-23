// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * ClassName: PriorityThreadMain<br/>
 * Description: 优先级线程池测试<br/>
 * Author: GW<br/>
 * Create： 2017年7月23日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PriorityThreadMain {

	public static void main(String[] args) {
		
		// 创建初始化线程池，使用PriorityBlockingQueue实现
		ExecutorService executor = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		for (int i = 0; i < 1000; i++) {
			executor.execute(new PriorityThread("testPriorityThread_testing_" + Integer.toString(999 - i)));
		}
		
		executor.shutdown();
		
	}
}
