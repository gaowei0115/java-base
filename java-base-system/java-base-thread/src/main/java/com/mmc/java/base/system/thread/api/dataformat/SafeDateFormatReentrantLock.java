// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.dataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * className: SafeDateFormatReentrantLock<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SafeDateFormatReentrantLock {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static ReentrantLock lock = new ReentrantLock();
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		lock.tryLock();
		try {
			return sdf.format(date);
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param source
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String source) throws ParseException {
		lock.tryLock();
		try {
			return sdf.parse(source);
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Date date1 = new Date();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatReentrantLock.format(date1);
				System.out.println(str);
			}
		});
		Thread.sleep(1000);
		final Date date2 = new Date();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatReentrantLock.format(date2);
				System.out.println(str);
			}
		});
		
		t.start();
		t1.start();
	}
}
