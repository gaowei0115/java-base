// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.api.binary;

/** 
 * className: MisBrinaryTest<br/>
 * Description: 按位非~运算<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月1日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MisBrinaryTest {

	public static void main(String[] args) {
		System.out.println(~29);
		System.out.println(Integer.toBinaryString(29));
		System.out.println(Integer.toBinaryString(~29));
		/**
		 * 原码：00000000000000000000000000011101
		 * 反码：01111111111111111111111111100010
		 * 补码：01111111111111111111111111100010
		 * 16 + 8 + 4
		 * 
		 * 11101100
		 * 10010100
		 */
	}
}
