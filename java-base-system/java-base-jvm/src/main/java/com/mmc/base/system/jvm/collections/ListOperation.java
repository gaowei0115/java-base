// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.collections;

import java.util.ArrayList;
import java.util.List;

/** 
 * ClassName: CollectionsOperation<br/>
 * Description: 实现集合交并差运算<br/>
 * Author: GW<br/>
 * Create： 2017年8月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ListOperation {

	/**
	 * Description：List集合实现交集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcList
	 * @param destList
	 * @return
	 */
	public static List<String> interSelect(List<String> srcList, List<String> destList) {
		List<String> srcList_temp = new ArrayList<String>();
		srcList_temp.addAll(srcList);
		
		List<String> destList_temp = new ArrayList<String>();
		destList_temp.addAll(destList);
		srcList_temp.retainAll(destList_temp);
		return srcList_temp;
	}
	
	/**
	 * Description：List集合并集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcList
	 * @param destList
	 * @return
	 */
	public static List<String> union(List<String> srcList, List<String> destList) {
		List<String> srcList_temp = new ArrayList<String>();
		srcList_temp.addAll(srcList);
		
		List<String> destList_temp = new ArrayList<String>();
		destList_temp.addAll(destList);
		srcList_temp.addAll(destList_temp);
		return srcList_temp;
	}
	
	/**
	 * Description：List集合实现差集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcList
	 * @param destList
	 * @return
	 */
	public static List<String> diff(List<String> srcList, List<String> destList) {
		List<String> srcList_temp = new ArrayList<String>();
		srcList_temp.addAll(srcList);
		
		List<String> destList_temp = new ArrayList<String>();
		destList_temp.addAll(destList);
		srcList_temp.removeAll(destList_temp);
		return srcList_temp;
	}
	
	public static void main(String[] args) {
		List<String> srcList = new ArrayList<String>();
		srcList.add("lusi");
		srcList.add("tony");
		srcList.add("jike");
		
		List<String> destList = new ArrayList<String>();
		destList.add("lusi");
		destList.add("mike");
		
		System.out.println("list 实现交集：");
		List<String> result = interSelect(srcList, destList);
		for (String key : result) {
			System.out.println(key);
		}
		
		System.out.println("list 实现并集：");
		result = union(srcList, destList);
		for (String key : result) {
			System.out.println(key);
		}
		
		System.out.println("list 实现差集：");
		result = diff(srcList, destList);
		for (String key : result) {
			System.out.println(key);
		}
	}
}
