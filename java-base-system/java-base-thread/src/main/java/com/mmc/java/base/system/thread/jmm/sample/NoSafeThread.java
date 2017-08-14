// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.sample;

/** 
 * className: NoSafeThread<br/>
 * Description: 非线程安全数据共享<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class NoSafeThread implements Runnable {

	private int state;
	
	public int getState() {
		return state;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			state = state + 1;
			System.out.println(Thread.currentThread().getName() + " >> " + state);
			Thread.sleep(10);
		} catch (Exception e) {
			
		}
	}

}
