// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.testframe;

import java.util.concurrent.Semaphore;

import org.junit.runner.notification.RunListener.ThreadSafe;

/** 
 * ClassName: BoundedBuffer<br/>
 * Description: 有界缓存区<br/>
 * Author: GW<br/>
 * Create： 2017年8月29日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
@ThreadSafe
public class BoundedBuffer<E> {

	// 设置信号量
	private final Semaphore availableItems;
	private final Semaphore availableSpaces;
	
	// 缓存数组
	private final E[] elements;
	
	private int putposition = 0;
	private int takeposition = 0;
	
	/**
	 * Construtor(@param capacity)
	 * BoundedBuffer.java
	 */
	@SuppressWarnings("unchecked")
	public BoundedBuffer(int capacity) {
		availableItems = new Semaphore(0);
		availableSpaces = new Semaphore(capacity);
		elements = (E[])new Object[capacity];
	}
	
	/**
	 * Description：保存入口<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param x
	 */
	public void put(E x) throws InterruptedException {
		availableSpaces.tryAcquire();
		doInsert(x);
		availableItems.release();
	}
	
	/**
	 * Description：获取入口<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 * @throws InterruptedException
	 */
	public E take() throws InterruptedException {
		availableItems.tryAcquire();
		E item = doExtract();
		availableSpaces.release();
		return item;
	}
	
	/**
	 * Description：执行获取<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public synchronized E doExtract() {
		int i = takeposition;
		E x = elements[i];
		takeposition = (++i == elements.length) ? 0 : i;
		return x;
	}
	
	/**
	 * Description：执行保存缓存数据<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param x
	 */
	private synchronized void doInsert(E x) {
		int i = putposition;
		elements[i] = x;
		putposition = (++i == elements.length) ? 0 : i;
	}
	
	/**
	 * Description：是否为空<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public boolean isEmpty() {
		return availableItems.availablePermits() == 0;
	}
	
	/**
	 * Description：是否满<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public boolean isFull() {
		return availableSpaces.availablePermits() == 0;
	}
}
