// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.auto;

/** 
 * className: BaseBoundedBuffer<br/>
 * Description: 有界缓存基类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class BaseBoundedBuffer<T> {

	private final T[] elements;
	private int tail;
	private int head;
	private int count;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	protected BaseBoundedBuffer(int capacity) {
		this.elements = (T[])new Object[capacity];
		this.capacity = capacity;
	}
	
	/**
	 * Description：存储<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param t
	 */
	protected synchronized void doPut(T t) {
		elements[tail] = t;
		if (++tail == capacity) {
			tail = 0;
		}
		++count;
	}
	
	/**
	 * Description：取值<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	protected synchronized T doTake() {
		T t = elements[head];
		elements[head] = null;
		if (++head == capacity) {
			head = 0;
		}
		--count;
		return t;
	}
	
	/**
	 * Description：空<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public synchronized boolean isEmpty() {
		return count == 0;
	}
	
	/**
	 * Description：满<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public synchronized boolean isFull() {
		return count == capacity;
	}
}
