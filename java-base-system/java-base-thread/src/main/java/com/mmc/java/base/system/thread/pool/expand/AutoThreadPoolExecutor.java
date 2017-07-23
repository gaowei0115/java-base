// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.expand;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * ClassName: AutoThreadPoolExecutor<br/>
 * Description: 扩展ThreadPoolExecutor线程池<br/>
 * Author: GW<br/>
 * Create： 2017年7月23日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class AutoThreadPoolExecutor extends ThreadPoolExecutor {

	/**
	 * Construtor(@param corePoolSize
	 * Construtor(@param maximumPoolSize
	 * Construtor(@param keepAliveTime
	 * Construtor(@param unit
	 * Construtor(@param workQueue)
	 * AutoThreadPoolExecutor.java
	 */
	public AutoThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadPoolExecutor#beforeExecute(java.lang.Thread, java.lang.Runnable)
	 */
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("beforeExecute Thread Name ： " + ((AuthoThread)r).getName() + " Tid:" + t.getId());
		super.beforeExecute(t, r);
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadPoolExecutor#afterExecute(java.lang.Runnable, java.lang.Throwable)
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("afterExecute TID: " + Thread.currentThread().getId());
		System.out.println("pool size : " + this.getPoolSize());
	}
}
