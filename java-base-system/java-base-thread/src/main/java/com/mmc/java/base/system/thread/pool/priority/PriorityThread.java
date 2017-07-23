// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.priority;

/** 
 * ClassName: PriorityThread<br/>
 * Description: 阻塞线程池实现，继承compare方法，实现比较<br/>
 * Author: GW<br/>
 * Create： 2017年7月23日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PriorityThread implements Runnable, Comparable<PriorityThread>{

	private String name;
	
	/**
	 * Construtor()
	 * PriorityThread.java
	 */
	public PriorityThread() {
		
	}
	
	/**
	 * Construtor(@param name)
	 * PriorityThread.java
	 */
	public PriorityThread(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PriorityThread o) {
		int comp = Integer.parseInt(this.name.split("_")[2]);
		int to = Integer.parseInt(this.name.split("_")[2]);
		if (comp > to) {
			return 1;
		} else if (comp < to) {
			return -1;
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
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
