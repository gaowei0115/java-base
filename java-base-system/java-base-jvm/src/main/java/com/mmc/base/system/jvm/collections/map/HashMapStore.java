// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.collections.map;

import java.util.HashMap;
import java.util.Map;

/** 
 * className: HashMapStore<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class HashMapStore {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		System.out.println("key2" == new String("key2"));
		map.put(new String("key2"), "value2");
		System.out.println("length:" + map.size());
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		int h = 0;
		System.out.println((h = "key1".hashCode()) ^ (h >>> 16));
		System.out.println((h = "key2".hashCode()) ^ (h >>> 16));
	}
}

