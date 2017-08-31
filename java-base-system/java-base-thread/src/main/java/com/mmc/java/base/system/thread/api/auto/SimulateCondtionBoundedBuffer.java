// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.auto;

/** 
 * className: CondtionBoundedBuffer<br/>
 * Description: 条件有界缓存区，通过wait和notifyAll模拟条件实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimulateCondtionBoundedBuffer<T> extends BaseBoundedBuffer<T> {

	/**
	 * @param capacity
	 */
	protected SimulateCondtionBoundedBuffer(int capacity) {
		super(capacity);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param t
	 * @throws InterruptedException
	 */
	public synchronized void put(T t) throws InterruptedException {
		if (isFull()) {
			wait();
		}
		doPut(t);
		boolean isEmpty = isEmpty();
		if (isEmpty) {
			notifyAll();
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized T take() throws InterruptedException {
		if (isEmpty()) {
			wait();
		}
		T t = doTake();
		boolean isFull = isFull();
		if (isFull) {
			notifyAll();
		}
		return t;
	}

}
