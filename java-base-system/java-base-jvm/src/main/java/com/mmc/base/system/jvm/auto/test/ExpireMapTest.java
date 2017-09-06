// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.auto.test;

import com.mmc.base.system.jvm.auto.cache.ExpireMap;

/** 
 * className: ExpireMapTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月6日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ExpireMapTest {

	public static void main(String[] args) {
		ExpireMap<String, String> expireMap = new ExpireMap<String, String>();
		expireMap.put("1", "a", 1000L);
		expireMap.put("2", "b", 1000L);
		expireMap.put("3", "c", 1000L);
		expireMap.put("4", "d", 1000L);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (String key : expireMap.keySet()) {
			System.out.println("key:" + key + ", value:" + expireMap.get(key));
		}
		
	}
}
