// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension;

/** 
 * ClassName: ClientThread<br/>
 * Description: 模拟客户端请求<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ClientThread extends Thread {

	// 请求队列,同一个进程服务端与客户端公用一个队列
	private RequestQueue queue;
	
	/**
	 * @param queue
	 * @param name
	 */
	public ClientThread(RequestQueue queue, String name) {
		super(name);
		this.queue = queue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Request request = new Request("RequestId:" + i + " Thread_Name:" + Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			queue.addRequest(request);// 提交请求
			try {
				Thread.sleep(10);// 模拟客户端请求速度大于服务端处理速度
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("ClientThread Name is: " + Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName() + " request end.");
	}
}
