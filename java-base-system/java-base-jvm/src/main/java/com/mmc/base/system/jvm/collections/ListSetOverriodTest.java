// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * ClassName: ListSetOverriodTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月13日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ListSetOverriodTest {

	public static void addList(List<Integer> list) {
		for (int i = -3; i < 3; i++) {
			list.add(i);
		}
	}
	
	public static void addSet(Set<Integer> set) {
		for (int i = -3; i < 3; i++) {
			set.add(i);
		}
	}
	
	public static void removeList(List<Integer> list) {
		for (int i = 0; i < 3; i++) {
			list.remove(i);
		}
	}
	
	public static void removeSet(Set<Integer> set) {
		for (int i = 0; i < 3; i++) {
			set.remove(i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		Set<Integer> set = new HashSet<Integer>();
		
		addList(list);
		addSet(set);
		
		removeList(list);
		
		removeSet(set);
		// -3,-2,-1,0,1,2
		for (int i : list) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();
		for (int i : set) {
			System.out.print(i);
			System.out.print(",");
		}
	}
}
