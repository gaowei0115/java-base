// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.api.binary;

/** 
 * className: AndBinaryTest<br/>
 * Description: 按位与计算<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月1日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AndBinaryTest {

	public static void main(String[] args) {
		System.out.println(15 & 7);
		System.out.println(Integer.toBinaryString(15));
		System.out.println(Integer.toBinaryString(7));
		System.out.println(Integer.toHexString(15));
		System.out.println(Integer.toOctalString(15));
	}
}
