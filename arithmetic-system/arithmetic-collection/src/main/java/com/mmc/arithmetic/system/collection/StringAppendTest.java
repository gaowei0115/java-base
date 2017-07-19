// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.collection;

/** 
 * className: StringAppendTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月18日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StringAppendTest {

	public static void main(String[] args) {
		append1();
		append();
		concat();
	}
	
	public static void concat() {
		long start = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < 10000; i++) {
			str.concat(String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("cost time " + (end - start) + " ms");
	}
	
	public static void append1() {
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
		}
		String str = sb.toString();
		long end = System.currentTimeMillis();
		System.out.println("cost time " + (end - start) + " ms");
	}
	
	public static void append() {
		String str = "";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			str = str + i;
		}
		long end = System.currentTimeMillis();
		System.out.println("cost time " + (end - start) + " ms");
	}
}
