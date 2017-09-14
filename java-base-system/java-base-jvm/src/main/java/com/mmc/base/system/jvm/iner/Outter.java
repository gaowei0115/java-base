// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.iner;

/** 
 * ClassName: Outer<br/>
 * Description: 成员内部测试<br/>
 * Author: GW<br/>
 * Create： 2017年9月13日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Outter {
	
	/**
	 * 此用例说明为啥内部类可以访问外部类的成员变量方法
	 * 通过javap -verbose 查看编译器内部类的组织结构发现，内部有一个外部类的引用
	 */

	private int a;
	
	private String str;
	
	public void fun() {
		System.out.println(a + " ：： " + str);
	}
	
	class Inner {
		private int b;
		private String str1;
		
		public void fun1() {
			System.out.println(b + " :: " + str1);
		}
	}
}
