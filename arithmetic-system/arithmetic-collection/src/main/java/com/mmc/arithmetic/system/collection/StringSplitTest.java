// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.collection;

import java.util.StringTokenizer;

/** 
 * className: StringSplitTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月18日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StringSplitTest {

	public static void main(String[] args) {
//		split();
//		tokenizerSplit();
		autoSplit();
	}
	
	public static void moresybmo(String[] args) {
		String subStr = "a;,b,c|d";
		
		String[] result = subStr.split("[|;|,||]");
		for (String r : result) {
			System.out.print(r);
		}
	}
	
	public static void autoSplit() {
		long start = System.currentTimeMillis();
		String splitStr = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
			sb.append(";");
		}
		splitStr = sb.toString();
		String temp = splitStr;
		for (int i = 0; i < 10; i++) {
			while (true) {
				String str = null;
				int j = temp.indexOf(";");
				if (j < 0) {
					break;
				}
				str = temp.substring(0, j);
				temp = temp.substring(j + 1);
			}
			temp = splitStr;
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + " ms");
	}
	
	public static void split() {
		// cost time : 4901 ms
		long start = System.currentTimeMillis();
		String splitStr = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
			sb.append(";");
		}
		splitStr = sb.toString();
		
		// 循环一万次分割
		for (int i = 0; i < 10000; i++) {
			splitStr.split(";");
		}
		
		long end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + " ms");
	}
	
	public static void tokenizerSplit() {
		// 
		long start = System.currentTimeMillis();
		String splitStr = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
			sb.append(";");
		}
		splitStr = sb.toString();
		
		StringTokenizer stringTokenizer = new StringTokenizer(splitStr, ";");
		
		// 循环一万次分割
		for (int i = 0; i < 10000; i++) {
			while (stringTokenizer.hasMoreTokens()) {
				stringTokenizer.nextToken();
			}
			stringTokenizer = new StringTokenizer(splitStr, ";");
		}
		
		long end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + " ms");
	}
}
