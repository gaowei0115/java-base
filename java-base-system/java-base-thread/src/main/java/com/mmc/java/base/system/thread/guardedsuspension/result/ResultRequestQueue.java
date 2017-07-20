// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension.result;

import java.util.LinkedList;

/** 
 * ClassName: RequestQueue<br/>
 * Description: 模拟请求队列<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ResultRequestQueue {

	// 使用LinkedList双向列表实现队列
	private LinkedList<ResultRequest> queue = new LinkedList<ResultRequest>();
	
	/**
	 * Description：获取请求对象，队列为空时线程等待<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public synchronized ResultRequest getRequest() {
		while (queue.size() == 0) {
			// 队列为空时，等待
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 返回Request队列中第一个Request请求
		return queue.remove();
	}
	
	/**
	 * Description：添加请求到队列<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param request
	 */
	public synchronized void addRequest(ResultRequest request) {
		queue.add(request);
		notifyAll();
	}
	
}
