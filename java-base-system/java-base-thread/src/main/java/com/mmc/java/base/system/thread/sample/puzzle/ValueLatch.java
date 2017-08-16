// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.sample.puzzle;

import java.util.concurrent.CountDownLatch;

/** 
 * className: ValueLatch<br/>
 * Description: 使用CountDownLatch实现闭锁<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ValueLatch<T> {

	private T value ;
	private final CountDownLatch done = new CountDownLatch(1);
	
	public boolean isSet() {
		return (done.getCount() == 0);
	}
	
	public synchronized void setValue(T newValue) {
		if (!isSet()) {
			value = newValue;
			done.countDown();
		}
	}
	
	public T getValue() throws InterruptedException {
		done.await();
		synchronized (this) {
			return value;
		}
	}
}
