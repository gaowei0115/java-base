// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.dataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * className: SafeDateFormatDemo<br/>
 * Description: 线程安全DateFormat测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SafeDateFormatDemo {

	public static String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static Date parse(String source) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(source);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Date date1 = new Date();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatDemo.format(date1);
				System.out.println(str);
			}
		});
		Thread.sleep(5000);
		final Date date2 = new Date();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				String str = SafeDateFormatDemo.format(date2);
				System.out.println(str);
			}
		});
		
		t.start();
		t1.start();
	}
}
