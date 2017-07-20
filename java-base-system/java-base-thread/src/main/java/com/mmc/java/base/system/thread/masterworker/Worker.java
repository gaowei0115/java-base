// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker;

import java.util.Map;
import java.util.Queue;

/** 
 * className: Worker<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class Worker implements Runnable{

	// 任务队列
	private Queue<Object> taskQueue = null;
	// 子任务处理结果集
	private Map<String, Object> resultMap = null;
	
	
	/**
	 * Description：具体业务处理<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param input
	 * @return
	 */
	public Object handle(Object input) {
		return input;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			if (taskQueue == null) {
				continue;
			}
			Object input = taskQueue.poll();
			if (input == null) {
				break;
			}
			Object re = handle(input);
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param result
	 */
	public void setResultMap(Map<String, Object> result) {
		this.resultMap = result;
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
