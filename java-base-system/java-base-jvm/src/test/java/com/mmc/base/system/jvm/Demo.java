// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm;

/** 
 * className: Demo<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月1日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class Demo {

	public static void main(String[] args) {
		int i = 0;
		int sum = 1;
		for (i = 1; i < 9; i++) {
			sum *= 2;
		}
		System.out.println(sum-1);
		
		System.out.println(Integer.toBinaryString(255));
	}
}
