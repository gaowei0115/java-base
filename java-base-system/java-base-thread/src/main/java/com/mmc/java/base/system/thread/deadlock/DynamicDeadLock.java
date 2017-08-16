// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.deadlock;

/** 
 * ClassName: DynamicDeadLock<br/>
 * Description: 动态死锁分析<br/>
 * Author: GW<br/>
 * Create： 2017年8月16日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class DynamicDeadLock {

	public void transferAmont(Account fromAccount, Account toAccount, Long money) throws Exception {
		synchronized(fromAccount) {
			Thread.sleep(100);
			synchronized(toAccount) {
				System.out.println("fromAccount -- money");
				System.out.println("toAccount ++ money");
			}
		}
	}
	
	public static void main(String[] args) {
		final Account fromAccount = new Account();
		final Account toAccount = new Account();
		final DynamicDeadLock deadLock = new DynamicDeadLock();
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
	
	
	static class Account {
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return super.hashCode();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
	}
}
