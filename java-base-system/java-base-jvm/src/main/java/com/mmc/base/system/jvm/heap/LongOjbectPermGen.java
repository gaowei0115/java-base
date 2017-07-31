// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.heap;

/** 
 * ClassName: LongOjbectPermGen<br/>
 * Description: 长期存活对象进入老年代<br/>
 * Author: GW<br/>
 * Create： 2017年7月31日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class LongOjbectPermGen {

	private static final int one_mb = 1024 * 1024;
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[one_mb / 4];
		allocation2 = new byte[4 * one_mb];
		allocation3 = new byte[4 * one_mb];
		allocation3 = null;
		allocation4 = new byte[4 * one_mb];
	}
	
	public static void main(String[] args) {
		testTenuringThreshold();
	}
}
