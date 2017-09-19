// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.framework.test.thread.asyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.mmc.java.base.system.framework.thread.asyn.AsynBaseDeal;


/** 
 * className: AsynQueue<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AsynQueueTest {

	@Test
	public void test() {
		String key1 = AsynBaseDeal.seriNumber();
		String key2 = AsynBaseDeal.seriNumber();
		for (int i = 0; i < 50; i++) {
			Runnable task = new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + " .. start");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId() + " .. end");
				}
			};
			String key = "";
			if ( i % 2 == 0) {
				key = key1;
			} else {
				key = key2;
			}
			AsynBaseDeal.action(key, task);
		}
	}
	
	@Test
	public void test01() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(100);
		Runnable task = new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getName() + " .. start");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " .. end");
			}
		};
		
		for (int i = 0; i < 100; i++) {
			executor.execute(task);
		}
		executor.awaitTermination(100000, TimeUnit.SECONDS);
		executor.shutdown();
	}
}
