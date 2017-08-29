// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.testframe;

import org.junit.Assert;
import org.junit.Test;

/** 
 * ClassName: BoundedBufferTest<br/>
 * Description: 有界缓存区测试<br/>
 * Author: GW<br/>
 * Create： 2017年8月29日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class BoundedBufferTest extends TestCase {

	/**
	 * Description：创建有界缓存区时测试为空情况<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	@Test
	public void testIsEmptyWhenConstructed() {
		BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
		Assert.assertTrue(bb.isEmpty());
		Assert.assertTrue(bb.isFull());
	}
	
	/**
	 * Description：插入数据时测试有界缓存区为空情况<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @throws InterruptedException 
	 */
	@Test
	public void testIsFullAfterPuts() throws InterruptedException {
		BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
		for (int i = 0; i < 10; i++) {
			bb.put(i);
		}
//		bb.take();
		Assert.assertTrue(bb.isFull());
	}
}
