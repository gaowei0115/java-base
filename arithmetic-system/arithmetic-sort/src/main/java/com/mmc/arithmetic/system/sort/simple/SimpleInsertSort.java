// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.simple;

import com.mmc.arithmetic.system.sort.BaseSort;

/** 
 * className: SimpleInsertSort<br/>
 * Description: 插入排序规则<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimpleInsertSort extends BaseSort<Double>{

	/* (non-Javadoc)
	 * @see com.mmc.arithmetic.system.sort.BaseSort#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(Double[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}
		int length = arrays.length;
		int out, in;
		for (out = 1; out < length; out++) {
			Double temp = arrays[out];
			in = out;
			while (in > 0 && arrays[in - 1] >= temp) {
				arrays[in] = arrays[in - 1];
				in--;
			}
			arrays[in] = temp;
		}
	}
	
	/**
	 * Description：返回数组中间值<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public Double media(Double[] arrays) {
		sort(arrays);
		int media = arrays.length / 2;
		return arrays[media];
	}
	
	/**
	 * Description：去重<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 * @return
	 */
	public void noDups(Double[] arrays) {
		sort(arrays);
		int length = arrays.length;
		// 设置标志位
		Double mark = Double.MAX_VALUE;
		for (int i = 0; i < length - 1; i++) {
			if (arrays[i].equals(arrays[i + 1])) {
				arrays[i] = mark;// 将相同的元素都置为标志位
			}
		}
		
		int index = 0;
		for (int j = 0; j < length; j++) {
			if (arrays[j] != mark) {
				arrays[index++] = arrays[j];
			}
		}
		for (int i = length - 1; i > index - 1; i--) {
			arrays[i] = null;
		}
	}

}
