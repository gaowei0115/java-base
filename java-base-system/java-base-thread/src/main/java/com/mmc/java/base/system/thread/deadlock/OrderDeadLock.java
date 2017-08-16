// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.deadlock;

/** 
 * className: OrderDeadLock<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class OrderDeadLock {

	private final Object left = new Object();
	private final Object right = new Object();
	
	public void leftRight() {
		synchronized(left) {
			synchronized(right) {
				System.out.println("leftright....");
			}
		}
	}
	
	public void rightLeft() {
		synchronized(right) {
			synchronized(left) {
				System.out.println("rightleft....");
			}
		}
	}
	
	public static void main(String[] args) {
		final OrderDeadLock deadLock = new OrderDeadLock();
		new Thread(new Runnable() {
			
			public void run() {
				deadLock.leftRight();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				deadLock.rightLeft();
			}
		}).start();
	}
}
