// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.volatil;

/** 
 * className: NoSafeVolatileThread<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class NoSafeVolatileThread implements Runnable {

	private volatile int state;
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
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
			Thread.sleep(100);
		} catch (Exception e) {
			
		}
	}

}
