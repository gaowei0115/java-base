// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.closeLock;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: CountDownLatchPC<br/>
 * Description: 使用CountDownLatch闭锁实现生产消费模型<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class CountDownLatchPC {

	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
	
	private final CountDownLatch mainLatch;
	private final CountDownLatch producerLatch;
	private final CountDownLatch customerLatch;
	private static final AtomicInteger totalProducerT = new AtomicInteger(0);
	private static final AtomicInteger totalCustomer = new AtomicInteger(0);
	private static final AtomicInteger producerSum = new AtomicInteger(0);
	private static final AtomicInteger customerSum = new AtomicInteger(0);
	
	
	/**
	 * @param mainSum
	 * @param producerSum
	 * @param customerSum
	 */
	public CountDownLatchPC(int mainSum, int producerSum, int customerSum) {
		this.mainLatch = new CountDownLatch(mainSum);
		this.producerLatch = new CountDownLatch(producerSum);
		this.customerLatch = new CountDownLatch(customerSum);
	}
	
	/**
	 * Description：主测试入口<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService es ;
		final int mainSum = 2;
		final int producerSum = 5;
		final int customerSum = 5;
		final CountDownLatchPC mainLatch = new CountDownLatchPC(mainSum, producerSum, customerSum);
		Thread t = new Thread(new Runnable() {
		
			public void run() {
				try {
					mainLatch.mainLatch.await();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Producer producer = mainLatch.new Producer(mainLatch.producerLatch);
				Customer customer = mainLatch.new Customer(mainLatch.customerLatch);
				ExecutorService ese = Executors.newFixedThreadPool(customerSum);
				for (int i = 0; i < producerSum; i++) {
					ese.execute(producer);
					ese.execute(customer);
				}
				try {
					mainLatch.producerLatch.await();
					mainLatch.customerLatch.await();
					ese.shutdown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		es = Executors.newFixedThreadPool(mainSum);
		for (int i = 0; i < mainSum; i++) {
			es.execute(t);
		}
		
		for (int i = 0; i < mainSum; i++) {
			mainLatch.mainLatch.countDown();
		}
		
		es.shutdown();
		System.out.println("producer sum " + totalProducerT.get());
		System.out.println("customer sum " + totalCustomer.get());
	}
	
	
	/**
	 * className: Producer<br/>
	 * Description: 模拟生产者<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月31日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	class Producer implements Runnable {
		
		private CountDownLatch latch;
		
		public Producer(CountDownLatch latchInit) {
			this.latch = latchInit;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " producer running");
				int sum = 0;
				for (int i = 0; i <10; i++) {
					int seed = new Random().nextInt(9999);
					try {
						queue.put(seed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sum += seed;
				}
				producerSum.getAndAdd(sum);
				totalProducerT.incrementAndGet();
			} finally {
				latch.countDown();
			}
		}
		
	}
	
	/**
	 * className: Customer<br/>
	 * Description: 模拟消费者模型<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月31日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	class Customer implements Runnable {

		private CountDownLatch latch;
		
		public Customer(CountDownLatch latchinit) {
			this.latch = latchinit;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			System.out.println(Thread.currentThread().getName() + " customer running");
			Integer seed;
			try {
				while ((seed = queue.take()) != null) {
					customerSum.getAndAdd(seed.intValue());
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				totalCustomer.incrementAndGet();
				latch.countDown();
			}
		}
		
	}
	
	
}
