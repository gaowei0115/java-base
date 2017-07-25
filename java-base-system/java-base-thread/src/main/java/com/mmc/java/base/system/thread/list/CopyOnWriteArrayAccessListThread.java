// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.list;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/** 
 * ClassName: AccessListThread<br/>
 * Description: CopyOnWriteArrayList get性能测试<br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class CopyOnWriteArrayAccessListThread implements Runnable {

	protected String name;
	
	Random random = new Random();
	
	private List<Object> list;
	
	public CopyOnWriteArrayAccessListThread() {
		
	}
	
	/**
	 * Construtor(@param name)
	 * AccessListThread.java
	 */
	public CopyOnWriteArrayAccessListThread(String name) {
		this.name = name;
		list = new CopyOnWriteArrayList<Object>();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			for (int i = 0; i < 500; i++) {
				getList(random.nextInt(1000));
			}
			Thread.sleep(random.nextInt(100));
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param index
	 * @return
	 */
	public Object getList(int index) {
		return list.get(index);
	}

}
