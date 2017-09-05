// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.auto.cache;

import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * className: CacheMapManager<br/>
 * Description: 自定义带有缓存过期功能的map<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月5日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class CacheMapManager {

	
	class CacheMap extends HashMap<Object, Object> {
		
		// 默认缓存时间
		private final static long EXPIRE = 10;
		
		private final ReentrantLock inputLock = new ReentrantLock();
		
		private final ReentrantLock getLock = new ReentrantLock();
		
		/**
		 * Description：存放数据<br/>
		 * Author：GW<br/>
		 * History: (version) Author DateTime Note <br/>
		 * @param key
		 * @param value
		 */
		public void push(Object key, Object value) {
			push(key, value, EXPIRE);
		}
		
		/**
		 * Description：<br/>
		 * Author：GW<br/>
		 * History: (version) Author DateTime Note <br/>
		 * @param key
		 * @param value
		 * @param expire
		 */
		public void push(Object key, Object value, long expire) {
			inputLock.lock();
			try {
				CacheNode cacheNode = new CacheNode(key, value, expire);
				put(key, cacheNode);
			} finally {
				inputLock.unlock();
			}
		}
		
		/**
		 * className: Node<br/>
		 * Description: 数据节点<br/>
		 * Author: GW<br/>
		 * CreateTime： 2017年9月5日<br/>
		 *
		 * History: (version) Author DateTime Note <br/>
		 */
		final class CacheNode {
			private final Object key;
			private final Object value;
			// 秒级
			private final long expireTime;
			private final long putTime;
			
			/**
			 * @param key
			 * @param value
			 * @param expireTimeInit
			 */
			public CacheNode(Object key, Object value, long expireTimeInit) {
				this.key = key;
				this.value = value;
				this.expireTime = expireTimeInit;
				this.putTime = System.currentTimeMillis();
			}
			
			/**
			 * Description：验证是否过期<br/>
			 * Author：GW<br/>
			 * History: (version) Author DateTime Note <br/>
			 * @return
			 */
			public boolean isExpire() {
				long current = System.currentTimeMillis();
				if ((current - putTime) > expireTime) {
					return true;
				}
				return false;
			}
		}
	}
	
}
