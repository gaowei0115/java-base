// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.jmm.resort;

/** 
 * className: PossibleReordering<br/>
 * Description: 重排序示例<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class PossibleReordering {

	static volatile int x = 0, y = 0;
	static volatile int a = 0, b = 0;
	
	public static void main(String[] args) throws Exception {
		final Object object = new Object();
		Thread one = new Thread(new Runnable() {
			
			public void run() {
				a = 1;
				synchronized(object.getClass()) {
				x = b;
				}
			}
		});
		
		Thread two = new Thread(new Runnable() {
			
			public void run() {
				synchronized(object.getClass()) {
				b = 1;
				}
				y = a;
			}
		});
		
		one.start();
		two.start();
		one.join();
		two.join();
		System.out.println("(" + x + "," + y  + ")");
	}
}
