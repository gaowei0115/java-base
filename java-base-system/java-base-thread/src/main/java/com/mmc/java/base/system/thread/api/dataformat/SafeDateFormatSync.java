// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.dataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * className: SafeDateFormatSync<br/>
 * Description: 通过同步方式实现多线程安全<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SafeDateFormatSync {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * Description：日期转换<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		synchronized(sdf) {
			return sdf.format(date);
		}
	}
	
	/**
	 * Description：解析日期<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateStr) throws ParseException {
		synchronized(sdf) {
			return sdf.parse(dateStr);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Date date1 = new Date();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatSync.format(date1);
				System.out.println(str);
			}
		});
		Thread.sleep(1000);
		final Date date2 = new Date();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatSync.format(date2);
				System.out.println(str);
			}
		});
		
		t.start();
		t1.start();
	}
}
