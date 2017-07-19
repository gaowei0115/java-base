// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 
 * className: ListTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ListTest {
	
	public static void main(String[] args) {
//		arrayList();
//		linkedList();
		
		System.out.println("----------------------------------");
//		arrayListAdd();
		linkedListAdd();
	}
	
	
	public static void linkedListAdd() {
		long start = System.currentTimeMillis();
		Object obj = new Object();
		List<Object> objList = new LinkedList<Object>();
		for (int i = 0; i < 500000; i++) {
			objList.add(0, obj);
		}
		
//		for (int i = 0; i < 10000; i++) {
//			objList.add(80000, new Object());
//		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("linkedListadd index cost time " + (end - start) + " ms");
	}

	public static void arrayListAdd() {
		long start = System.currentTimeMillis();
		Object obj = new Object();
		List<Object> objList = new ArrayList<Object>();
		for (int i = 0; i < 500000; i++) {
			objList.add(0, obj);
		}
//		for (int i = 0; i < 10000; i++) {
//			objList.add(80000, new Object());
//		}
		long end = System.currentTimeMillis();
		
		System.out.println("arraylistadd index cost time " + (end - start) + " ms");
	}
	
	
	public static void linkedList() {
		long start = System.currentTimeMillis();
		Object obj = new Object();
		List<Object> objList = new LinkedList<Object>();
		for (int i = 0; i < 500000; i++) {
			objList.add(obj);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("linkedList add cost time " + (end - start) + " ms");
	}

	public static void arrayList() {
		long start = System.currentTimeMillis();
		Object obj = new Object();
		List<Object> objList = new ArrayList<Object>();
		for (int i = 0; i < 500000; i++) {
			objList.add(obj);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("arraylist add cost time " + (end - start) + " ms");
	}
}
