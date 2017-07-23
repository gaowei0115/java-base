// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.expand;

/**
 * ClassName: AuthoThread<br/>
 * Description: 自定义线程<br/>
 * Author: GW<br/>
 * Create： 2017年7月23日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class AuthoThread implements Runnable {

	private String name;

	/**
	 * Construtor()
	 * PriorityThread.java
	 */
	public AuthoThread() {
		
	}

	/**
	 * Construtor(@param name)
	 * PriorityThread.java
	 */
	public AuthoThread(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			// 模拟工作
			Thread.sleep(1000);
			System.out.println("name: " + name);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
