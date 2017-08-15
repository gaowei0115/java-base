// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.block.delay;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/** 
 * className: DelayMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DelayMain {

	static class DelayThread implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getId() + " >> 延迟加载了。。。" + new Date());
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(" start ....");
		DelayFactoryBean factoryBean = DelayFactoryBean.getInstance();
		for (int i = 0; i < 5; i++) {
			factoryBean.put(10 * i, new DelayThread(), TimeUnit.SECONDS);
		}
		factoryBean.executor();
		System.out.println(" end ....");
	}
}
