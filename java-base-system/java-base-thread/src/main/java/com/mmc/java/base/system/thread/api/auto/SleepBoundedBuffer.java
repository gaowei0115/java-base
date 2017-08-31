// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.auto;

/** 
 * className: SleepBoundedBuffer<br/>
 * Description: 通过轮询休眠形式实现有界缓存<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SleepBoundedBuffer<T> extends BaseBoundedBuffer<T> {

	// 休眠时间
	private static final long SLEEP_TIME = 1000;
	
	/**
	 * @param capacity
	 */
	protected SleepBoundedBuffer(int capacity) {
		super(capacity);
	}

	/**
	 * Description：保存数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param t
	 * @throws InterruptedException
	 */
	public void put(T t) throws InterruptedException {
		while (true) {
			synchronized(this) {
				if (!isFull()) {
					doPut(t);
					return;
				}
			}
			Thread.sleep(SLEEP_TIME);
		}
	}
	
	/**
	 * Description：获取数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 * @throws InterruptedException
	 */
	public T take() throws InterruptedException {
		while (true) {
			synchronized(this) {
				if (!isEmpty()) {
					return doTake();
				}
			}
			Thread.sleep(SLEEP_TIME);
		}
	}
}
