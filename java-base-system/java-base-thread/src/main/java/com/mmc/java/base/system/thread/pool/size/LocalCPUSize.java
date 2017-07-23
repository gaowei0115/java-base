// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.size;

/** 
 * ClassName: LocalCPUSize<br/>
 * Description: 本机CPU数量计算<br/>
 * Author: GW<br/>
 * Create： 2017年7月23日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class LocalCPUSize {

	public static void main(String[] args) {
		int num = Runtime.getRuntime().availableProcessors();
		System.out.println("CPU num : " + num);
	}
}
