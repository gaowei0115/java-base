// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.lockSupport;

import java.util.concurrent.locks.LockSupport;

/** 
 * className: LockSupportMock<br/>
 * Description: 模拟LockSupport应用<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LockSupportMock {

	
	public static void main(String[] args) {
		LockThread lockThread = new LockThread();
		Thread t = new Thread(lockThread);
		t.start();
		try {
			// 模拟任务处理过程
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		LockSupport.park(lockThread);
		LockSupport.park();
//		LockSupport.unpark(t);
	}
	
	
	/**
	 * className: LockThread<br/>
	 * Description: 模拟线程<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月14日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class LockThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			while (true) {
				System.out.println("runing....");
			}
		}
	}
}
