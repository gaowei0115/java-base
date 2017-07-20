// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension;

/** 
 * ClassName: ServerThread<br/>
 * Description: 模拟服务端进程<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ServerThread extends Thread {

	// 请求队列
	private RequestQueue queue;
	
	/**
	 * @param queue
	 */
	public ServerThread(RequestQueue queue, String name) {
		super(name);
		this.queue = queue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			// 循环处理客户端请求
			Request request = queue.getRequest();
			try {
				// 模拟服务端处理超时
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
	}

}
