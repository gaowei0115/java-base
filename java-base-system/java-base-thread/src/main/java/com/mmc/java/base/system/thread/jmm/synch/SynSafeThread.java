// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.synch;

/** 
 * className: SynSafeThread<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SynSafeThread implements Runnable {

	private volatile int state;
	
	public synchronized int getState() {
		return state;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			synchronized (SynSafeThread.class) {
				state = state + 1;
				System.out.println(Thread.currentThread().getName() + " >> " + state);
			}
			Thread.sleep(100);
		} catch (Exception e) {
			
		}
	}
}
