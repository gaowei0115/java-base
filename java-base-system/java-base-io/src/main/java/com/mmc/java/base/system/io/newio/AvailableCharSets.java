// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

/** 
 * ClassName: AvailableCharSets<br/>
 * Description: 查看可用编码集<br/>
 * Author: GW<br/>
 * Create： 2017年8月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class AvailableCharSets {

	public static void main(String[] args) {
		SortedMap<String, Charset> charsetMap = Charset.availableCharsets();
		Set<String> keys = charsetMap.keySet();
		for (String key : keys) {
			Charset charset = charsetMap.get(key);
			Set<String> aliasess = charset.aliases();
			System.out.println("{" + key + " : [");
			for (String alias : aliasess) {
				System.out.print(alias);
				System.out.print(", ");
			}
			System.out.println("]");
		}
	}
}
