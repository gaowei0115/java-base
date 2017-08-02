// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.closeLock;

/** 
 * className: MockThreadPlay<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月2日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MockThreadPlay implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println(Thread.currentThread().getId() + " : running start");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(Thread.currentThread().getId() + " : running end");
	}
	
	public static void main(String[] args) {
		MockCloseLock closeLock = new MockCloseLock();
		try {
			long time = closeLock.timeTasks(4, new MockThreadPlay());
			System.out.println("cost time : " + time + " ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
