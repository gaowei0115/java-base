// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.heap;

/** 
 * className: SettingThreadSum<br/>
 * Description: 设置系统支持最大线程数 -Xss<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SettingThreadSum {

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		try {
			for (i = 0; i < 10000; i++) {
				new ThreadSum().start();
			}
		} catch (Exception e) {
			System.out.println("count thread sum : " + i);
		}
	}
	
	/**
	 * className: ThreadSum<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年7月31日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	public static class ThreadSum extends Thread {
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
