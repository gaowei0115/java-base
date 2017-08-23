// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.simple;

import com.mmc.arithmetic.system.sort.BaseSort;

/** 
 * className: SimpleObjectInsertSortTest<br/>
 * Description: 对象插入排序测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimpleObjectInsertSortTest {

	public static void main(String[] args) {
		BaseSort<Person> sort = new SimpleObjectInsertSort();
		
		Person[] arrays = new Person[5];
		Person p = new Person("zhangsan", "1111", "beijing");
		arrays[0] = p;
		p = new Person("lisi", "1111", "beijing");
		arrays[1] = p;
		p = new Person("wangwu", "1111", "beijing");
		arrays[2] = p;
		p = new Person("zhaoliu", "1111", "beijing");
		arrays[3] = p;
		p = new Person("sunqi", "1111", "beijing");
		arrays[4] = p;
		
		sort.sort(arrays);
		System.out.println("排序结果：");
		for (Person pp : arrays) {
			System.out.println(pp.getName());
		}
	}
}
