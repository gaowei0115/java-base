// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/** 
 * className: ExpandThreaPool<br/>
 * Description: 扩展线程池，添加计算功能<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ExpandThreaPool extends ThreadPoolExecutor {

	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	private final AtomicLong numTasks = new AtomicLong();
	private final AtomicLong totalTime = new AtomicLong();
	
	/**
	 * @param corePoolSize
	 * @param maximumPoolSize
	 * @param keepAliveTime
	 * @param unit
	 * @param workQueue
	 */
	public ExpandThreaPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadPoolExecutor#beforeExecute(java.lang.Thread, java.lang.Runnable)
	 */
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		System.out.println("Thread " + t + " : start " + r);
		startTime.set(System.nanoTime());
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadPoolExecutor#afterExecute(java.lang.Runnable, java.lang.Throwable)
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		try {
			long endTime = System.nanoTime();
			long taskTime = endTime - startTime.get();
			numTasks.incrementAndGet();
			totalTime.addAndGet(taskTime);
			System.out.println("Thread " + t + " : start " + r + " time:" + taskTime + " ns");
		} finally {
			super.afterExecute(r, t);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadPoolExecutor#terminated()
	 */
	@Override
	protected void terminated() {
		try {
			System.out.println(String.format("Terminated: avg time=%d ns", totalTime.get() / numTasks.get()));
		} finally {
			super.terminated();
		}
	}
	
	/**
	 * className: ExpandThread<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月16日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class ExpandThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(" start business ....");
			try {
				// 模拟业务处理过程
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
			System.out.println(" end business ....");
		}
	}
	
	public static void main(String[] args) {
		ExpandThread expandThread = new ExpandThread();
		int nThreads = 10;
		ExecutorService es = new ExpandThreaPool(nThreads, nThreads, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < nThreads; i++) {
			es.execute(expandThread);
		}
		es.shutdown();
	}
}
