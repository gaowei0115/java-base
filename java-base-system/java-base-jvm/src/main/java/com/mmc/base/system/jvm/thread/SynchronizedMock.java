// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.thread;

/** 
 * ClassName: SynchronizedMock<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月13日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SynchronizedMock {

	public static void main(String[] args) {
		MockService mockService = new MockService();
		Thread t1 = new Thread(new SynchronizedThread(mockService, "1"));
		
		Thread t2 = new Thread(new SynchronizedThread(mockService, "2"));
		t1.start();
		t2.start();
	}
	
	static class MockService{
		
		public synchronized void fun1() {
			System.out.println("进入 fun1");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("fun1");
		}
		
		public synchronized void fun2() {
			System.out.println("进入 fun2");
			System.out.println("fun2");
		}
	}
	
	
	static class SynchronizedThread implements Runnable {
		
		private final MockService mockService;
		private final String remark;
		
		public SynchronizedThread(MockService mockService, String remark) {
			this.mockService = mockService;
			this.remark = remark;
		}
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				if ("1".equals(remark)) {
					this.mockService.fun1();
				} else {
					this.mockService.fun2();
				}
			} catch (Exception e) {
				
			}
		}
		
	}
}
