// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.executor;

/** 
 * className: ExecutorThread<br/>
 * Description: 自定义线程对象<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月9日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ExecutorThread implements Runnable {

	private final Integer count;
	
	public ExecutorThread(Integer i) {
		count = i;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println(Thread.currentThread().getId() + " 执行.... cc " + count);
	}

}
