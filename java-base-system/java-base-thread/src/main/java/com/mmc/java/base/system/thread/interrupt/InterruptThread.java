// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.interrupt;

/** 
 * ClassName: InterruptThread<br/>
 * Description: 线程终止测试<br/>
 * Author: GW<br/>
 * Create： 2017年7月26日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class InterruptThread extends Thread {

	boolean stop = false;
	
	public static void main(String[] args) throws Exception {
		InterruptThread thread = new InterruptThread();
		
		System.out.println("Startint thread......");
		thread.start();
		Thread.sleep(300);
		System.out.println("interrupting thread.......");
		thread.interrupt(); // 线程并没有中断，只是对线程标记了一种状态
		
		Thread.sleep(300);
		System.out.println("stop application... ");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (!stop) {
			System.out.println("thread running .....");
			long time = System.currentTimeMillis();
			try {
				boolean falg = this.isInterrupted();
				if (falg) {
					System.out.println("线程中断....");
					break;
				}
			} catch (Exception e) {
				System.out.println("线程中断");
			}
			while (System.currentTimeMillis() - time < 1000) {
				
			}
			System.out.println("Thread exist under request....");
		}
	}
}
