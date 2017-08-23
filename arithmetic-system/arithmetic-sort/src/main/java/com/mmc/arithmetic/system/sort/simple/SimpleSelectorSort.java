// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.simple;

import com.mmc.arithmetic.system.sort.BaseSort;

/** 
 * className: SimpleSelectorSort<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimpleSelectorSort extends BaseSort<Double> {

	/* (non-Javadoc)
	 * @see com.mmc.arithmetic.system.sort.BaseSort#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(Double[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return ;
		}
		
		int length = arrays.length;
		int out, in;
		for (out = 0; out < length - 1; out++) {
			Double temp = arrays[out];
			for (in = out + 1; in < length; in++) {
				if (large(temp, arrays[in])) {
					temp = arrays[in];
				}
			}
			// 交换
			swap(arrays, out, in - 1);
		}
	}

}
