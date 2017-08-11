// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.cas;

/** 
 * className: InterruptedThread<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月11日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class InterruptedThread implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("thread state interrupted");
				break;
			}
			System.out.println("test interrupt...");
		}
	}
	
	public static void main(String[] args) throws Exception {
		InterruptedThread interruptedThread = new InterruptedThread();
		Thread t = new Thread(interruptedThread);
		t.start();
		Thread.sleep(100);
		t.interrupt();
		System.out.println(t.isInterrupted());
	}

}
