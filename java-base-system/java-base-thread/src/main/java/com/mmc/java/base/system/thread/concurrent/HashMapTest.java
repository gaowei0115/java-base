// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.concurrent;

import java.util.HashMap;
import java.util.Map;

/** 
 * className: HashMapTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月21日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class HashMapTest {

	public static void main(String[] args) {
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("key1", "test1");
		maps.put("key2", "test2");
		maps.put("key3", "test3");
		maps.put("key4", "test4");
		maps.clear();
		for (String key : maps.keySet()) {
			System.out.println("key : " + key + ", value : " + maps.get(key));
		}
	}
}
