// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.auto.cache;

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

	private final CacheMap cacheMap;
	
	/**
	 */
	private CacheMapManager() {
		cacheMap = new CacheMap();
	}
	
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static CacheMapManager getInstance() {
		return CacheHolder.instance;
	}
	
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		cacheMap.push(key, value);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @param value
	 * @param expire
	 */
	public void put(Object key, Object value, long expire) {
		cacheMap.push(key, value, expire);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		return cacheMap.pop(key);
	}
	
	/**
	 * className: CacheHolder<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年9月6日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class CacheHolder {
		public static final CacheMapManager instance = new CacheMapManager();
	}
	
	
	/**
	 * className: CacheMap<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年9月6日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	class CacheMap extends HashMap<Object, Object> {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// 默认缓存时间
		private final static long EXPIRE = 1000;
		
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
		 * Description：<br/>
		 * Author：GW<br/>
		 * History: (version) Author DateTime Note <br/>
		 * @param key
		 * @return
		 */
		public Object pop(Object key) {
			try {
				getLock.lock();
				CacheNode cacheNode = (CacheNode) get(key);
				if (cacheNode != null) {
					if (cacheNode.isExpire()) {
						// 过期 -- 清除数据
						remove(key);
						return null;
					}
					return cacheNode.value;
				}
			} finally {
				getLock.unlock();
			}
			return null;
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

			/**
			 * @return the key
			 */
			public Object getKey() {
				return key;
			}

			/**
			 * @return the value
			 */
			public Object getValue() {
				return value;
			}

			/**
			 * @return the expireTime
			 */
			public long getExpireTime() {
				return expireTime;
			}

			/**
			 * @return the putTime
			 */
			public long getPutTime() {
				return putTime;
			}
		}
	}
	
}
