// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.store;

/**
 * className: StringInterr<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StringInterr {

	/**
	 * Description: 测试String intern方法<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		String str1 = new StringBuilder().append("gw").append("mmc").toString();
//		
//		String str2 = new StringBuilder().append("ja").append("va").toString();
//		
//		System.out.println(str1.intern() == str1);
//		System.out.println(str2.intern() == str2);
//		
//		String str3 = "java";
//		System.out.println(str3 == str2.intern());
		
		String s0= "kvill";   // 指向常量池中的引用
		String s1=new String("kvill");   // 定义指向堆区引用
		String s2=new String("kvill");   // 定义指向堆区引用
		System.out.println( s0==s1 );   // false 常量池引用与 堆中引用内存地址不一样
		System.out.println("---------------");  
		s1.intern();  // 将s1对应的实例值加入常量池中，如果常量池中存在，则返回常量池中的引用地址，不存在返回原引用地址
		s2=s2.intern(); // 把常量池中“kvill”的引用赋给s2  返回常量池中存储的此变量的内存地址引用
		System.out.println( s0==s1);  
		System.out.println( s0==s1.intern() );  
		System.out.println( s0==s2 );  
		
		// 254449608
		String javaStr = new StringBuilder().append("ja").append("va").toString();
		System.out.println(Addressor.addressOf(javaStr));
		System.out.println(Addressor.addressOf(javaStr.intern()));
		System.out.println(Addressor.addressOf("java"));
		
		System.out.println("==============================");
		// 第一次调用intern方法存入常量池时，如果不存在则添加到常量池中，返回原引用地址，如果存在返回常量池中引用地址
		String otherStr = new StringBuilder().append("gw").append("mmc").toString();
		System.out.println(Addressor.addressOf(otherStr));
		System.out.println(Addressor.addressOf(otherStr.intern()));
		System.out.println(Addressor.addressOf("gwmmc".intern()));

	}
}
