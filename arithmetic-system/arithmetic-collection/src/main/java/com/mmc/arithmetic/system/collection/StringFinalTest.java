// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.collection;

/** 
 * className: StringFinalTest<br/>
 * Description: 测试字符串不可变性<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月18日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StringFinalTest {

	public static void main(String[] args) {
		
		String a = "abc";
		// 定义b时，会先去堆查找是字符串常量池中查找"abc"，存在，则直接使用，不在重新创建 即：a和b变量指向堆中引用是相同。
		String b = "abc";
		// 通过new 创建对象，导致引用地址与a和b变量不一致，最终赋值的abc也是指向常量池存储。
		String c = new String("abc");
		
		System.out.println("a == b : " + (a == b));
		
		System.out.println("a == c : " + (a == c));
		
		System.out.println("a == c.intern() : " + (a == c.intern()));
	}
}
