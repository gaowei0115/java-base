// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.volatil;

/** 
 * ClassName: VolatileTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class VolatileTest {

//	volatile boolean isExist;
	boolean isExist;
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public void tryExist() {
		if (isExist == !isExist) {
			System.exit(0);
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public void swap() {
		this.isExist = !isExist;
	}
	
	public static void main(String[] args) throws Exception {
		final VolatileTest volatileTest = new VolatileTest();
		Thread mainThread = new Thread() {
			/* (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				System.out.println("main thread start");
				while (true) {
					System.out.println("main .......");
					volatileTest.tryExist();
				}
			}
		};
		
		mainThread.start();
		
		Thread swapThread = new Thread() {
			/* (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				System.out.println("swap thread start");
				while(true) {
					System.out.println("swap ....");
					volatileTest.swap();
				}
			}
		};
		swapThread.start();
		
		Thread.sleep(100);
	}
}
