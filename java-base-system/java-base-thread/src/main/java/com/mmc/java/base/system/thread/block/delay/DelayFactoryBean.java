// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.block.delay;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * className: DelayFactoryBean<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DelayFactoryBean {

	/**
	 * 延迟加载队列
	 */
	private DelayQueue<DelayItem<?>> queues = new DelayQueue<DelayItem<?>>();

	private static ExecutorService executor;
	// 执行结果
	private static Set<Future<?>> futureSet = new HashSet<Future<?>>();

	/**
	 */
	private DelayFactoryBean() {

	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @return
	 */
	public static DelayFactoryBean getInstance() {
		executor = Executors.newCachedThreadPool();
		return LazyHolder.instance;
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @return
	 */
	public static DelayFactoryBean getInstance(ExecutorService executorInit) {
		executor = executorInit;
		return LazyHolder.instance;
	}

	/**
	 * Description：执行入口<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public void executor() {
		while (queues != null && queues.size() > 0) {
			// Map<Thread, StackTraceElement[]> map =
			// Thread.getAllStackTraces();
			// System.out.println("线程数--------------" + map.size());
			// System.out.println(System.currentTimeMillis());
			// System.out.println(queues.size());
			// System.out.println("线程状态---------" +
			// Thread.currentThread().getState());
			try {
				DelayItem<?> delayItem = queues.take();
				if (delayItem != null) {
					Runnable task = delayItem.getTask();
					if (task == null) {
						continue;
					}
					// executor.execute(task);
					Future<?> future = executor.submit(task);
					futureSet.add(future);
				}
			} catch (Exception e) {

			}
		}
		// 验证等待直接结果
		for (Future<?> f : futureSet) {
			try {
				// 等待执行完成
				f.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		futureSet = null;
	}

	/**
	 * Description：添加延迟加载任务<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @param time
	 * @param task
	 * @param timeUnit
	 */
	public void put(long time, Runnable task, TimeUnit timeUnit) {
		long nanoTime = TimeUnit.NANOSECONDS.convert(time, timeUnit);
		DelayItem<?> item = new DelayItem<Runnable>(nanoTime, task);
		queues.put(item);
	}

	/**
	 * Description：结束任务<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @param task
	 * @return
	 */
	public boolean endTask(DelayItem<Runnable> task) {
		return queues.remove(task);
	}

	/**
	 * className: LazyHolder<br/>
	 * Description: JVM加载初始化加锁控制单例模式懒加载实现<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月15日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	private static class LazyHolder {
		public static DelayFactoryBean instance = new DelayFactoryBean();
	}
	
}
