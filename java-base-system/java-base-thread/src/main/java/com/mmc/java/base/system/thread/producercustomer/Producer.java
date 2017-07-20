// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.producercustomer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * ClassName: Producer<br/>
 * Description: 模拟生产者<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Producer implements Runnable {
	
	private volatile boolean isRunning = true;
	// 内存缓冲区
	private BlockingQueue<PcData> blockingQueue;
	
	private static AtomicInteger count = new AtomicInteger();
	
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<PcData> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		PcData pcData = null;
		Random random = new Random();
		
		System.out.println("start producer id : " + Thread.currentThread().getId());
		
		try {
			while (isRunning) {
				Thread.sleep(random.nextInt(SLEEPTIME));
				pcData = new PcData(count.incrementAndGet());// 构造任务数据
				System.out.println(pcData + " is put into queue");
				if (!blockingQueue.offer(pcData, 2, TimeUnit.SECONDS)) {
					System.err.println("fail into queue : " + pcData);
				}
			}
		} catch (Exception e) {
			
		}
	}

	public void stop() {
		this.isRunning = false;	
	}
}
