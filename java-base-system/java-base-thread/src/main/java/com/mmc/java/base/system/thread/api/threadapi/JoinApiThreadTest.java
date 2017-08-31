// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi;

/** 
 * className: JoinApiThreadTest<br/>
 * Description: join方法测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class JoinApiThreadTest {

	
	public static void main(String[] args) {
		Thread t = new Thread(new ExecutorTask());
		ExecutorThread t1 = new ExecutorThread(t);
		
		t.start();
		
		t1.start();
		try {
			t.join();
			
			System.out.println("join finish");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	static class ExecutorTask implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println("Begin sleep");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end sleep");
		}
		
	}
	
	static class ExecutorThread extends Thread {
		
		private Thread thread;
		
		public ExecutorThread(Thread t) {
			this.thread = t;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			holdTask();
		}
		
		public void holdTask() {
			synchronized(thread) {
				System.out.println(Thread.currentThread().getId() + " get thread lock");
				try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getId() + " release thread lock");
			}
		}
	}
}
