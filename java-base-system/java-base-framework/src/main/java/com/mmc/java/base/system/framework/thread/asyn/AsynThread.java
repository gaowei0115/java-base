// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.framework.thread.asyn;

import java.util.concurrent.ExecutorService;

/** 
 * className: AsynThread<br/>
 * Description: 异步线程<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AsynThread implements Runnable {

	private final String key;
	private final AsynQueue asynQueue;
	private final ExecutorService executor;
	
	public AsynThread(String key, AsynQueue asynQueue, ExecutorService executor) {
		this.key = key;
		this.asynQueue = asynQueue;
		this.executor = executor;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			Runnable task = asynQueue.poll(key);
			if (task == null) {
				return;
			}
			System.out.println(key + " 异步开始处理任务 :: " + Thread.currentThread().getName());
			executor.execute(task);
		}
	}

}
