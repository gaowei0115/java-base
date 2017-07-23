// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker.future;

import java.util.Queue;
import java.util.concurrent.Callable;

/** 
 * className: WorkerFuture<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class WorkerFuture implements Callable<Object> {

	// 任务队列
	private Queue<Object> taskQueue;

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public Object call() throws Exception {
		while (true) {
			if (taskQueue == null) {
				continue;
			}
			Object obj = taskQueue.poll();
			if (obj == null) {
				break;
			}
			Integer i = (Integer)obj;
			return i * i * i;
		}
		return null;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param queue
	 */
	public void setTaskQueue(Queue<Object> queue) {
		this.taskQueue = queue;
	}

}
