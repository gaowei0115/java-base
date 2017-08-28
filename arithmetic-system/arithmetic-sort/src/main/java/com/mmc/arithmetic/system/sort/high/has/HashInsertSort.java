// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.high.has;

/** 
 * className: HashInsertSort<br/>
 * Description: 在谈插入排序<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月28日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class HashInsertSort {

	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param datas
	 */
	public static void sort(Double[] datas) {
		// 下标
		int in, out;
		int length = datas.length;
		for (in = 0; in < length; in++) {
			Double temp = datas[in];
			out = in;
			while (out < in && temp <= datas[out - 1]) {
				datas[out] = datas[out - 1];
				out--;
			}
		}
	}
}
