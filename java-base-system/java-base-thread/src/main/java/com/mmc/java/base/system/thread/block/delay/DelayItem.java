// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.block.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/** 
 * className: DelayItem<br/>
 * Description: 延迟队列对象<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DelayItem<T extends Runnable> implements Delayed {

	// 到期时间
	private final long time;
	// 任务对象
	private final T task;
	
	private final AtomicLong atomic = new AtomicLong(0);
	
	private final long n;
	
	public DelayItem(long timeout, T t) {
		time = System.nanoTime() + timeout;
		task = t;
		n = atomic.getAndIncrement();
	}
	
	public T getTask() {
		return task;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return task.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DelayItem) {
			return obj.hashCode() == hashCode() ? true : false;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Delayed o) {
		if (o == null) {
			return -1;
		}
		
		if (o == this) {
			return 0;
		}
		if (o instanceof DelayItem) {
			DelayItem<?> other = (DelayItem<?>) o;
			long diff = time - other.time;
			if (diff < 0) {
				return -1;
			} else if (diff > 0) {
				return 1;
			} else if (n < other.n) {
				return -1;
			} else {
				return 1;
			}
		}
		long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
		return (d == 0 ? 0 : (d < 0 ? -1 : 1));
	}

	/**
	 * 返回当前剩余延迟时间
	 */
	/* (non-Javadoc)
	 * @see java.util.concurrent.Delayed#getDelay(java.util.concurrent.TimeUnit)
	 */
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

}
