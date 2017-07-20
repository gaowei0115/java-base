// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.producercustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/** 
 * ClassName: ProducerCusetomerMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ProducerCusetomerMain {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<PcData> queue = new LinkedBlockingQueue<PcData>();
		
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Producer producer4 = new Producer(queue);
		
		Customer customer1 = new Customer(queue);
		Customer customer2 = new Customer(queue);
		Customer customer3 = new Customer(queue);
		Customer customer4 = new Customer(queue);
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(producer1);
		executorService.execute(producer2);
		executorService.execute(producer3);
		executorService.execute(producer4);
		executorService.execute(customer1);
		executorService.execute(customer2);
		executorService.execute(customer3);
		executorService.execute(customer4);
		
		Thread.sleep(10 * 1000);
		
		producer1.stop();
		producer2.stop();
		producer3.stop();
		producer4.stop();
		
		Thread.sleep(3000);
		executorService.shutdown();
	}
}
