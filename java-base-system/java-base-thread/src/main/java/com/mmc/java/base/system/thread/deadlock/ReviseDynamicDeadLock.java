// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.deadlock;

import com.mmc.java.base.system.thread.deadlock.DynamicDeadLock.Account;

/** 
 * ClassName: ReviseDynamicDeadLock<br/>
 * Description: 修正版动态死锁问题<br/>
 * Author: GW<br/>
 * Create： 2017年8月16日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ReviseDynamicDeadLock {
	
	private final Object lock = new Object();

	public void transferAmont(Account fromAccount, Account toAccount, Long money) throws Exception {
		
		class Helper{
			public void transfer() {
				System.out.println("fromAccount -- money");
				System.out.println("toAccount ++ money");
			}
		}
		
		int fromHash = System.identityHashCode(fromAccount);
		int toHash = System.identityHashCode(toAccount);
		
		if (fromHash < toHash) {
			synchronized(fromAccount) {
				Thread.sleep(100);
				synchronized(toAccount) {
					new Helper().transfer();
				}
			}
		} else if (fromHash > toHash) {
			synchronized(toAccount) {
				Thread.sleep(100);
				synchronized(fromAccount) {
					new Helper().transfer();
				}
			}
		} else {
			synchronized (lock) {
				synchronized(fromAccount) {
					Thread.sleep(100);
					synchronized(toAccount) {
						new Helper().transfer();
					}
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		final Account fromAccount = new Account();
		final Account toAccount = new Account();
		final ReviseDynamicDeadLock deadLock = new ReviseDynamicDeadLock();
		new Thread(new Runnable() {
			
			public void run() {
				try {
					deadLock.transferAmont(fromAccount, toAccount, 100L);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				try {
					deadLock.transferAmont(toAccount, fromAccount, 100L);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
}
