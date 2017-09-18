// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/** 
 * ClassName: ListIterRemove<br/>
 * Description: list集合遍历删除<br/>
 * Author: GW<br/>
 * Create： 2017年9月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ListIterRemove {

	private ArrayList<String> list = new ArrayList<String>();
	
	@Before
	public void setUp() {
		list.add("1111");
		list.add("2222");
		list.add("3333");
	}
	
	@Test
	public void test() {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			if ("2222".equals(temp)) {
				iter.remove();
			}
		}
		
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	@Test
	public void test01() {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			if ("2222".equals(temp)) {
				list.add("11111");
				list.remove("1111");
			}
		}
		
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	@Test
	public void test02() {
		for (String str : list) {
			if ("2222".equals(str)) {
				list.remove("2222");
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			if (temp.equals("2222")) {
				list.remove(temp);
			}
		}
	}
	
	/**
	 * Description：迭代器中删除索引下标时会导致concurrentModificationException<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	@Test
	public void test03() {
		try {
			Iterator<String> iter = list.iterator();
			while (iter.hasNext()) {
				String it = iter.next();
				if ("1111".equals(it)) {
					list.remove(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Description：迭代器中删除对象时<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	@Test
	public void test04() {
		try {
			Iterator<String> iter = list.iterator();
			while (iter.hasNext()) {
				String temp = iter.next();
				if (temp.equals("1111")) {
					list.remove("1111");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
