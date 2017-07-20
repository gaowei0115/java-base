// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension.result;

import java.util.ArrayList;
import java.util.List;

import com.mmc.java.base.system.thread.future.FutureData;

/**
 * ClassName: ResultClientThread<br/>
 * Description: 带有返回结果 模拟客户端进程<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ResultClientThread extends Thread {

	// 请求队列,同一个进程服务端与客户端公用一个队列
	private ResultRequestQueue queue;
	
	private List<ResultRequest> result = new ArrayList<ResultRequest>();

	/**
	 * @param queue
	 * @param name
	 */
	public ResultClientThread(ResultRequestQueue queue, String name) {
		super(name);
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			ResultRequest request = new ResultRequest(
					"RequestId:" + i + " Thread_Name:" + Thread.currentThread().getName());
			request.setResponse(new FutureData());
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			queue.addRequest(request);// 提交请求
			result.add(request);
			try {
				Thread.sleep(1000);// 设置等待时间，模拟等待服务器处理时间
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (ResultRequest rr : result) {
				System.out.println("ClientThread Name is: " + Thread.currentThread().getName() + " response is " + rr.getResponse().getResult());
			}
		}
		System.out.println(Thread.currentThread().getName() + " request end.");
	}
}
