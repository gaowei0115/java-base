// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: CasConuter<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月11日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class CasConuter implements Runnable{

	private volatile int count = 0;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			
		}
//		synchronized (this) {
			count = count + 1;
//		}
	}
	
	public static void main(String[] args) throws Exception {
		CasConuter casConuter = new CasConuter();
		int nThreads = 1000;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.execute(casConuter);
		}
		es.shutdown();
		Thread.sleep(1000);
		System.out.println(casConuter.count);
	}

}
