// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.block;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/** 
 * className: LinkedBlockingQuqueMock<br/>
 * Description: 阻塞链表队列测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LinkedBlockingQuqueMock {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<String>();
		strings.offer("str1");
		strings.offer("str2");
		strings.offer("str3");
		long start = System.nanoTime();
		while (strings.isEmpty()) {
			try {
				String result = strings.poll(10000, TimeUnit.SECONDS);
				System.out.println(">>> " + result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();
		System.out.println(" end cost : " + (end - start) + " ns");
	}
}
