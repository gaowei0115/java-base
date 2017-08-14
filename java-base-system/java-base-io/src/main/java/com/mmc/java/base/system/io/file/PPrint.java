// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.file;

import java.util.Arrays;
import java.util.Collection;

/** 
 * ClassName: PPrint<br/>
 * Description: 打印输出<br/>
 * Author: GW<br/>
 * Create： 2017年8月14日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PPrint {

	public static String pformat(Collection<?> c) {
		if (c.size() == 0) {
			return "[]";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Object obj : c) {
			if (c.size() != 1) {
				sb.append("\n");
			}
			sb.append(obj);
		}
		if (c.size() != 1) {
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}
	
	public static void pprint(Object[] c) {
		System.out.println(pformat(Arrays.asList(c)));
	}
}
