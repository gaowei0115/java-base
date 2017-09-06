// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.auto.cache;

import java.util.HashMap;

/** 
 * className: CacheMapper<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月6日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ExpireMap<K, V> extends HashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final HashMap<Object, Long> expireMap = new HashMap<Object, Long>();
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @param vlue
	 * @param expire
	 * @return
	 */
	public void put(K key, V value, Long expire) {
		expireMap.put(key, System.currentTimeMillis() + expire);
		put(key, value);
	}
	
	/* (non-Javadoc)
	 * @see java.util.HashMap#get(java.lang.Object)
	 */
	@Override
	public V get(Object key) {
		if (isExpire(key)) {
			remove(key);
			return null;
		}
		return super.get(key);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @return
	 */
	public boolean isExpire(Object key) {
		Long expire = expireMap.get(key);
		if (expire != null) {
			Long current = System.currentTimeMillis();
			if (expire.compareTo(current) < 0) {
				return true;
			}
			return false;
		}
		return false;
	}
	
}
