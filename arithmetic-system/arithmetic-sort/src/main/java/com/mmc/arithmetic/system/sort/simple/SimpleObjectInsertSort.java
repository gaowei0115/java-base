// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.simple;

import com.mmc.arithmetic.system.sort.BaseSort;

/** 
 * className: SimpleObjectInsertSort<br/>
 * Description: 对象插入排序<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimpleObjectInsertSort extends BaseSort<Person>{

	/* (non-Javadoc)
	 * @see com.mmc.arithmetic.system.sort.BaseSort#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(Person[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}
		
		int length = arrays.length;
		int out, in;
		for (out = 1; out < length; out++) {
			Person temp = arrays[out];
			in = out;
			while (in > 0 && arrays[in - 1].compareTo(temp) > 0) {
				arrays[in] = arrays[in - 1];
				in--;
			}
			arrays[in] = temp;
		}
	}
}
