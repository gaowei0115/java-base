// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.collections;

import java.util.HashSet;
import java.util.Set;

/** 
 * ClassName: SetOperation<br/>
 * Description: Set集合实现差集<br/>
 * Author: GW<br/>
 * Create： 2017年8月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SetOperation {

	/**
	 * Description：Set实现交集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcSet
	 * @param destSet
	 * @return
	 */
	public static <T> Set<T> interSelect(Set<T> srcSet, Set<T> destSet) {
		Set<T> srcSet_temp = new HashSet<T>();
		srcSet_temp.addAll(srcSet);
		Set<T> destSet_temp = new HashSet<T>();
		destSet_temp.addAll(destSet);
		// 实现交集运算
		srcSet_temp.retainAll(destSet_temp);
		
		return srcSet_temp;
	} 
	
	/**
	 * Description：Set实现并集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcSet
	 * @param destSet
	 * @return
	 */
	public static <T> Set<T> union(Set<T> srcSet, Set<T> destSet) {
		Set<T> srcSet_temp = new HashSet<T>();
		srcSet_temp.addAll(srcSet);
		Set<T> destSet_temp = new HashSet<T>();
		destSet_temp.addAll(destSet);
		// 实现交集运算
		srcSet_temp.addAll(destSet_temp);
		
		return srcSet_temp;
	}
	
	/**
	 * Description：Set实现差集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcSet
	 * @param destSet
	 * @return
	 */
	public static <T> Set<T> diff(Set<T> srcSet, Set<T> destSet) {
		Set<T> srcSet_temp = new HashSet<T>();
		srcSet_temp.addAll(srcSet);
		Set<T> destSet_temp = new HashSet<T>();
		destSet_temp.addAll(destSet);
		// 实现交集运算
		srcSet_temp.removeAll(destSet_temp);
		
		return srcSet_temp;
	}
	
	public static void main(String[] args) {
		Set<String> srcSet = new HashSet<String>();
		srcSet.add("zhangsan");
		srcSet.add("lisi");
		srcSet.add("wangwu");
		srcSet.add("zhaoliu");
		
		Set<String> destSet = new HashSet<String>();
		destSet.add("sunqi");
		destSet.add("wangba");
		destSet.add("lisi");
		
		Set<String> result = interSelect(srcSet, destSet);
		System.out.println(" set 集合 实现交集：");
		for (String r : result) {
			System.out.println(r);
		}
		
		result = union(srcSet, destSet);
		System.out.println(" set 集合 实现并集：");
		for (String r : result) {
			System.out.println(r);
		}
		
		result = diff(srcSet, destSet);
		System.out.println(" set 集合 实现差集：");
		for (String r : result) {
			System.out.println(r);
		}
		
	}
}
