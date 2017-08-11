// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 
 * className: MockCas<br/>
 * Description: 模拟CAS算法实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月11日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MockCas {

	private int value;
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public int get() {
		return value;
	}
	
	/**
	 * Description：模拟CAS比较交换算法<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param except
	 * 			预期值
	 * @param update
	 * 			更新值
	 * @return
	 */
	public synchronized int compareAndSwap(int except, int update) {
		// 内存中值
		int oldValue = value;
		if (oldValue == except) {
			// 预期值与内存中值一致 -- 更新内存值update
			value = update;
		}
		// 不管内存中值与期望值是否一致，默认都返回内存值
		return oldValue;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param except
	 * @param update
	 * @return
	 */
	public synchronized boolean compareAndSet(int except, int update) {
		return (except == compareAndSwap(except, update));
	}
	
	/**
	 * className: CasCounter<br/>
	 * Description: 自定义原子类型<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月11日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class CasCounter {
		
		private MockCas cas;
		
		public CasCounter() {
			cas = new MockCas();
		}
		
		public int get() {
			return cas.get();
		}
		
		/**
		 * Description：<br/>
		 * Author：GW<br/>
		 * History: (version) Author DateTime Note <br/>
		 * @return
		 */
		public int increment() {
			int v;
			do {
				v = cas.get();
			} while (!cas.compareAndSet(v, v + 1));
			return v + 1;
		}
		
	}

	static class MockCasThread implements Callable<String> {

		private CasCounter casConuter = new CasCounter();
		
		/* (non-Javadoc)
		 * @see java.util.concurrent.Callable#call()
		 */
		public String call() throws Exception {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				
			}
			casConuter.increment();
			return "SUCCESS";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		List<Future<String>> result = new ArrayList<Future<String>>();
		
		int nThreads = 100;
		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		MockCasThread casThread = new MockCasThread();
		for (int i = 0; i < nThreads; i++) {
			Future<String> f = es.submit(casThread);
			result.add(f);
		}
		es.shutdown();
		for (Future<String> f : result) {
			f.get();
		}
		System.out.println(casThread.casConuter.cas.get());
	}
}
