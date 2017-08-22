// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.constantpool;

/** 
 * ClassName: StringInter<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class StringInter {
	
	public static void main(String[] args) {
		String s1 = "java";
		System.out.println(s1 == s1.intern());
		
		String s2 = "test";
		String s3 = new String("test");
		System.out.println(s2 == s3);
		System.out.println(s2 == s2.intern());
		System.out.println(s2 == s3.intern());
		System.out.println(s3 == s3.intern());
	}

}
