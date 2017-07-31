// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.constantpool;

/** 
 * ClassName: ConstantsPoolTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月29日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ConstantsPoolTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String str1 = sb.append("计算机").append("程序").toString();
		StringBuilder sb1 = new StringBuilder();
		String str2 = sb1.append("ja").append("va").toString();
		System.out.println(str1.intern() == str1);
		System.out.println(str2.intern() == str2);
		
		String str3 = sb1.append("app").append("end").toString();
		System.out.println(str3.intern() == str3);
	}
}
