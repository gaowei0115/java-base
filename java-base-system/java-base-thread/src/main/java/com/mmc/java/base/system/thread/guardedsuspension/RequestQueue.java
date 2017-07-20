// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension;

import java.util.LinkedList;

/** 
 * ClassName: RequestQueue<br/>
 * Description: 模拟请求队列<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class RequestQueue {

	// 使用LinkedList双向列表实现队列
	private LinkedList<Request> queue = new LinkedList<Request>();
	
	/**
	 * Description：获取请求对象，队列为空时线程等待<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public synchronized Request getRequest() {
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
	public synchronized void addRequest(Request request) {
		queue.add(request);
		notifyAll();
	}
	
}
