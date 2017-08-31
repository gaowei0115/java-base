// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.auto;

import com.mmc.java.base.system.thread.api.auto.exception.BufferEmptyException;
import com.mmc.java.base.system.thread.api.auto.exception.BufferFullException;

/** 
 * className: GrumpyBoundedBuffer<br/>
 * Description: 通过异常形式实现有界缓存<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class GrumpyBoundedBuffer<T> extends BaseBoundedBuffer<T> {

	/**
	 * @param capacity
	 */
	protected GrumpyBoundedBuffer(int capacity) {
		super(capacity);
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param t
	 * @throws BufferFullException
	 */
	public synchronized void put(T t) throws BufferFullException {
		if (isFull()) {
			throw new BufferFullException();
		}
		doPut(t);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 * @throws BufferEmptyException
	 */
	public synchronized T take() throws BufferEmptyException {
		if (isEmpty()) {
			throw new BufferEmptyException();
		}
		return doTake();
	}
}
