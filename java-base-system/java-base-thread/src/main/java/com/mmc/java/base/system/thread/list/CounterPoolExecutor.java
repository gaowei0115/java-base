// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.list;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * ClassName: CounterPoolExecutor<br/>
 * Description: 自定义统计线程池<br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class CounterPoolExecutor extends ThreadPoolExecutor {
	
	private AtomicInteger count = new AtomicInteger(0);
	protected int TASK_COUNT = 2000;
	public long startTime = 0;
	public String funcname = "";

	/**
	 * Construtor(@param corePoolSize
	 * Construtor(@param maximunPoolSize
	 * Construtor(@param keepLiveTime
	 * Construtor(@param unit
	 * Construtor(@param blockingQueue)
	 * CounterPoolExecutor.java
	 */
	public CounterPoolExecutor(int corePoolSize, int maximunPoolSize, long keepLiveTime, TimeUnit unit, BlockingQueue<Runnable> blockingQueue) {
		super(corePoolSize, maximunPoolSize, keepLiveTime, unit, blockingQueue);
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadPoolExecutor#afterExecute(java.lang.Runnable, java.lang.Throwable)
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		int l = count.incrementAndGet();
		if (l == TASK_COUNT) {
			System.out.println();
		}
		super.afterExecute(r, t);
	}
}
