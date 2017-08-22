// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.dataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * className: NoSafeDateFromatDemo<br/>
 * Description: 非线程安全测试SimpleDateFormat<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class NoSafeDateFromatDemo {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return sdf.format(date);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param parseStr
	 * @return
	 */
	public static Date parse(String parseStr) {
		try {
			return sdf.parse(parseStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Date date1 = new Date();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				String str = NoSafeDateFromatDemo.format(date1);
				System.out.println(str);
			}
		});
		Thread.sleep(5000);
		final Date date2 = new Date();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				String str = NoSafeDateFromatDemo.format(date2);
				System.out.println(str);
			}
		});
		
		t.start();
		t1.start();
	}
}
