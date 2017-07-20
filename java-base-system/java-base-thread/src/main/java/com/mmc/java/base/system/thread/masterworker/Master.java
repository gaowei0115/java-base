// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/** 
 * className: Master<br/>
 * Description: master进程负责接收处理结果，分发任务<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class Master {

	// 任务队列
	protected Queue<Object> taskQueue = new ConcurrentLinkedQueue<Object>();
	// worker 进程队列
	protected Map<String, Thread> threadMap = new HashMap<String, Thread>();
	
	// 子任务处理结果集
	protected Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public Master() {
		
	}
	
	/**
	 * @param worker
	 * @param threadSize
	 */
	public Master(Worker worker, int threadSize) {
		worker.setTaskQueue(taskQueue);
		worker.setResultMap(resultMap);
		// 初始化线程
		for (int i = 0; i < threadSize; i++) {
			threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
		}
	}
	
	/**
	 * Description：提交任务<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param obj
	 */
	public void submit(Object obj) {
		taskQueue.add(obj);
	}
	
	/**
	 * Description：开启运行线程<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public void execute() {
		for (String key : threadMap.keySet()) {
			threadMap.get(key).start();
		}
	}
	
	/**
	 * Description：验证线程所有子线程是否执行完毕<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public boolean isComplete() {
		for (String key : threadMap.keySet()) {
			if (threadMap.get(key).getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	
	
}
