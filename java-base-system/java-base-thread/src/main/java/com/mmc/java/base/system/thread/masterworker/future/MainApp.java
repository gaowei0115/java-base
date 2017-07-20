// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker.future;

import java.util.Queue;

/** 
 * className: MainApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		
		WorkerFuture workerFuture = new WorkerFuture();
		FutureMaster futureMaster = new FutureMaster(10, workerFuture);
		
		for (int i = 1; i <= 100; i++) {
			futureMaster.submit(i);
		}
		futureMaster.execute();
		
		int res = 0;
		Queue<Object> resultQueue = futureMaster.resultQueue;
		while (futureMaster.isComplete()) {
			Object key = resultQueue.poll();
			if (key != null) {
				Integer i = (Integer)key;
				if (i != null) {
					res += i;
				}
			}
		}
		Thread.sleep(10000);
		System.out.println("计算结果：" + res);
		
	}
}
