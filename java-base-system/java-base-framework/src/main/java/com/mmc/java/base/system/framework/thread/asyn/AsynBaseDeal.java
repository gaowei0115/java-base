// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.framework.thread.asyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mmc.java.base.system.framework.utils.StringUtils;

/** 
 * className: AsynBaseDeal<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AsynBaseDeal {

	private final static AsynQueue ASYN_QUEUE = AsynQueue.getInstance();
	private final static ExecutorService executor = Executors.newCachedThreadPool();
	
	/**
	 * Description：指定队列<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @param task
	 */
	public static void action(String key, Runnable task) {
		if (StringUtils.isEmpty(key)) {
			System.out.println("消息队列标识key为空，不执行任务！");
			return;
		}
		if (task == null) {
			System.out.println("消息队列key={" + key + "}添加执行计划为空，不执行任务！");
			return;
		}
		ASYN_QUEUE.push(key, task);
		// 开启异步执行线程
		new Thread(new AsynThread(key, ASYN_QUEUE, executor)).start();
		
//		new Thread(new Runnable() {
//			
//			public void run() {
//				while (true) {
//					if (ASYN_QUEUE.isEmpty()) {
//						executor.shutdown();
//					}
//				}
//			}
//		}).start();
	}
	
	/**
	 * Description：获取序列号<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static String seriNumber() {
		return ASYN_QUEUE.serialNum();
	}
}
