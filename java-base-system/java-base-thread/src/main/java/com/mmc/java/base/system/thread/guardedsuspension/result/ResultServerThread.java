// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension.result;

import com.mmc.java.base.system.thread.future.FutureData;
import com.mmc.java.base.system.thread.future.RealData;

/**
 * ClassName: ResultServerThread<br/>
 * Description: 模拟带有返回结果服务端进程<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ResultServerThread extends Thread {

	// 请求队列
	private ResultRequestQueue queue;

	/**
	 * @param queue
	 */
	public ResultServerThread(ResultRequestQueue queue, String name) {
		super(name);
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			// 循环处理客户端请求
			ResultRequest request = queue.getRequest();
			try {
				// 模拟服务端处理超时
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			FutureData futureData = (FutureData) request.getResponse();
			RealData realData = new RealData(request.getParam());
			futureData.setRealData(realData);
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
	}
}
