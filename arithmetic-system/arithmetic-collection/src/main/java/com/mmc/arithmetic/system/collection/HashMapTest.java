// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * className: HashMapTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class HashMapTest {

	public static void main(String[] args) {
		String key = "1234";
		int h;
		int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		System.out.println(15 & hash);
		Map<String, String> map = new HashMap<String, String>();
		map.put("123", "456");
		
		LinkedHashMap<String, String> link = new LinkedHashMap<String, String>();
		link.put("", "");

	}
}
