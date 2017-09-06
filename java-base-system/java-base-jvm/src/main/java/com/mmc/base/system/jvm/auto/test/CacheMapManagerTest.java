// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.auto.test;

import com.mmc.base.system.jvm.auto.cache.CacheMapManager;

/** 
 * className: CacheMapManagerTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月6日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class CacheMapManagerTest {

	public static void main(String[] args) {
		CacheMapManager cacheMapManager = CacheMapManager.getInstance();
		cacheMapManager.put("1", "a", 1000);
		cacheMapManager.put("2", "b", 1000);
		cacheMapManager.put("3", "c", 1000);
		
		System.out.println(cacheMapManager.get("2"));
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(cacheMapManager.get("2"));
	}
}
