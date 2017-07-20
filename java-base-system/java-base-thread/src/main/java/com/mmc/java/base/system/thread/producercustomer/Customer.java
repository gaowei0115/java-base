// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.producercustomer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * ClassName: Customer<br/>
 * Description: 模拟消费者模式<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Customer implements Runnable {

	// 内存缓冲区
	private BlockingQueue<PcData> blockingQueue;

	private static final int SLEEPTIME = 1000;

	/**
	 * @param blockingQueue
	 */
	public Customer(BlockingQueue<PcData> blockingQueue) {
		this.blockingQueue = blockingQueue;
	} 
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("start customer id : " + Thread.currentThread().getId());
		Random r = new Random();
		while (true) {
			try {
				PcData pcData = blockingQueue.take();
				if (pcData != null) {
					int i = pcData.getIData();
					int res = i * i;
					System.out.println(MessageFormat.format("{0} * {1} = {2}", i, i, res));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
