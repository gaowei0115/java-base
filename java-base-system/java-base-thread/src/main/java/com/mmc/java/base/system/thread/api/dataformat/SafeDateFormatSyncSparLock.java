// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.dataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * className: SafeDateFormatLock<br/>
 * Description: 通过解析转换锁分离形式实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SafeDateFormatSyncSparLock {

	// 日期转换锁
	private static Object formatLock = new Object();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 日期解析锁
	private static Object parseLock = new Object();
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		synchronized(formatLock) {
			return sdf.format(date);
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
		synchronized(parseLock) {
			return sdf.parse(source);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Date date1 = new Date();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatSyncSparLock.format(date1);
				System.out.println(str);
			}
		});
		Thread.sleep(1000);
		final Date date2 = new Date();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatSyncSparLock.format(date2);
				System.out.println(str);
			}
		});
		
		t.start();
		t1.start();
	}
}
