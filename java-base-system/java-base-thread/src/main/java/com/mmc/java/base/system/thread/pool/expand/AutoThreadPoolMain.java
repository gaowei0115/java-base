// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.expand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/** 
 * ClassName: AutoThreadPoolMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月23日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class AutoThreadPoolMain {

	public static void main(String[] args) {
		ExecutorService executorService =  new AutoThreadPoolExecutor(100, 200, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 1000; i++) {
			executorService.execute(new AuthoThread("authoThreadPool_" + i));
		}
		executorService.shutdown();
	}
}
