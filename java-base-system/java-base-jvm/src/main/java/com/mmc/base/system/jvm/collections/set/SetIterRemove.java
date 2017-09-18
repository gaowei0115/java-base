// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/** 
 * ClassName: SetIterRemove<br/>
 * Description: set集合遍历删除<br/>
 * Author: GW<br/>
 * Create： 2017年9月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SetIterRemove {

	private Set<String> set = new HashSet<String>();
	
	@Before
	public void setUp() {
		set.add("1111");
		set.add("2222");
		set.add("3333");
	}
	
	/**
	 * Description：通过迭代器删除<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	@Test
	public void test01() {
		try {
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String temp = iter.next();
				if ("2222".equals(temp)) {
					iter.remove();
				}
			}
			
			for (String temp : set) {
				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Description：在迭代器中添加一个元素<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	@Test
	public void test02() {
		try {
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String temp = iter.next();
				if ("2222".equals(temp)) {
					set.add("3444");
				}
			}
			
			for (String temp : set) {
				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Description：在迭代器中通过集合remove删除<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	@Test
	public void test03() {
		try {
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String temp = iter.next();
				if ("2222".equals(temp)) {
					set.remove("2222");
				}
			}
			
			for (String temp : set) {
				System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
