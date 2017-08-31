// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.testframe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: PutTakeTest<br/>
 * Description: puttake测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class PutTakeModel {

	// 多线程执行框架
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	// 保存数据统计
	private final AtomicInteger putSum = new AtomicInteger(0);
	// 获取数据统计
	private final AtomicInteger takeSum = new AtomicInteger(0);
	// 设置栅栏
	private final CyclicBarrier barrier;
	// 有界缓存区
	private final BoundedBuffer<Integer> bb;
	private final int nTrials;
	private final int nPairs;
	
	
	public PutTakeModel(int capacity, int npairs, int ntrials) {
		bb = new BoundedBuffer<Integer>(capacity);
		this.nPairs = npairs;
		this.nTrials = ntrials;
		barrier = new CyclicBarrier(npairs * 2 + 1);
	}
	
	/**
	 * Description：测试模型入口<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @throws BrokenBarrierException 
	 * @throws InterruptedException 
	 */
	public void testModel() throws InterruptedException, BrokenBarrierException {
		for (int i = 0; i > nPairs; i++) {
			executor.execute(new Producer());
			executor.execute(new Customer());
		}
//		barrier.await();
//		barrier.await();
		System.out.println(" put == take ::: " + (putSum.get() == takeSum.get()));
		executor.shutdown();
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

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				int seed = (this.hashCode() ^ (int)System.nanoTime());
				int sum = 0;
				// 设置栅栏等待
				barrier.await();
				for (int i = nTrials; i > 0; i--) {
					bb.put(seed);
					sum += seed;
					seed = ToolUtils.random(seed);
				}
				putSum.getAndAdd(sum);
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * className: Customer<br/>
	 * Description: 消费者<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月31日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	class Customer implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				barrier.await();
				int sum = 0;
				for (int i = nTrials; i > 0; i--) {
					sum += bb.take();
				}
				takeSum.getAndAdd(sum);
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
}
