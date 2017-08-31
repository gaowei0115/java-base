// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.threadapi;

import static java.lang.System.out;
/** 
 * className: JoinApiThread<br/>
 * Description: join<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class JoinApiThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			public void run() {
				out.println("first thread runing ");
				out.println("first Thread sleep 2s");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				out.println("first thread end");
			}
		});
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				out.println("second thread runing ");
				out.println("second thread end");
			}
		});
		
		t.start();
		t1.start();
		t.join();
//		t.interrupt();
//		t.join();
	}
}
