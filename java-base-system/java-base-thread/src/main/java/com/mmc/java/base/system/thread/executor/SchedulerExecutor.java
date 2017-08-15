// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.executor;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/** 
 * className: SchedulerExecutor<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SchedulerExecutor {

	/**
	 * className: ScheduleThread<br/>
	 * Description: 模拟线程<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月15日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class ScheduleThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			long start = System.currentTimeMillis();
			try {
				System.out.println(Thread.currentThread().getName() + " >> start");
				System.out.printf("Starting at : %s\n", new Date());
				// 模拟任务执行时间
				Thread.sleep(5000);
				long end = System.currentTimeMillis();
				System.out.println(Thread.currentThread().getName() + " >> end cost time : " + (end - start) + " ms");
			} catch (Exception e) {
				
			}
		}
		
	}
	
	static class ScheduleCallable implements Callable<String>{

		/* (non-Javadoc)
		 * @see java.util.concurrent.Callable#call()
		 */
		public String call() throws Exception {
			long start = System.currentTimeMillis();
			try {
				System.out.println(Thread.currentThread().getName() + " >> start");
				System.out.printf("Starting at : %s\n", new Date());
				// 模拟任务执行时间
				Thread.sleep(5000);
				long end = System.currentTimeMillis();
				System.out.println(Thread.currentThread().getName() + " >> end cost time : " + (end - start) + " ms");
			} catch (Exception e) {
				
			}
			return "SUCCESS";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		ScheduleThread command = new ScheduleThread();
		ScheduleCallable callable = new ScheduleCallable();
		long delay = 10 * 1000;
		for (int i = 0; i < 5; i++) {
//			ses.schedule(command, 0L, delay, TimeUnit.MILLISECONDS);
//			ses.scheduleAtFixedRate(command, delay, delay, TimeUnit.MILLISECONDS);
			
			ScheduledFuture<String> future = ses.schedule(callable, 0, TimeUnit.SECONDS);
			future.get();
		}
//		ses.shutdown();
		ses.shutdown();
		ses.awaitTermination(1, TimeUnit.DAYS);
	}
}
