// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker.future;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * className: FutureMaster<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class FutureMaster {

	// 任务队列
	private Queue<Object> taskQueue = new ConcurrentLinkedQueue<Object>();
	// 处理结果队列
	protected Queue<Object> resultQueue = new ConcurrentLinkedQueue<Object>();
	// future任务执行队列
	private Map<String, FutureTask<Object>> futureTaskMap = new HashMap<String, FutureTask<Object>>();
	// 线程池大小
	private int threadSize;
	// 线程池操作对象
	private ExecutorService executorService;

	public FutureMaster() {

	}

	/**
	 * @param size
	 * @param worker
	 */
	public FutureMaster(int size, WorkerFuture worker) {
		this.threadSize = size;
		executorService = Executors.newFixedThreadPool(threadSize);
		FutureTask<Object> futureTask;
		for (int i = 0; i < threadSize; i++) {
			worker.setTaskQueue(taskQueue);
			futureTask = new FutureTask<Object>(worker);
			futureTaskMap.put(Integer.toString(i), futureTask);
		}
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @return
	 */
	public boolean isComplete() {
		if (!executorService.isTerminated()) {
			return false;
		}
		return true;
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public void execute() {
		for (String key : futureTaskMap.keySet()) {
			FutureTask<Object> futureTask = futureTaskMap.get(key);
			executorService.submit(futureTask);
			try {
				Object input = futureTask.get();
				if (input != null) {
					resultQueue.add(input);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @param obj
	 */
	public void submit(Object obj) {
		taskQueue.add(obj);
	}
}
