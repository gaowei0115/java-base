// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/** 
 * className: MainApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MainApp {

	public static void main(String[] args) throws Exception, ExecutionException {
		FutureTask<String> future = new FutureTask<String>(new RealData("test"));
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(future);
		System.out.println("请求完毕！");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		System.out.println(future.get());
		es.shutdown();
	}
}
