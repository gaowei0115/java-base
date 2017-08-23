// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.simple;

import com.mmc.arithmetic.system.sort.BaseSort;

/**
 * className: SimpleBubbingSort<br/>
 * Description: 简单排序 -- 冒泡排序<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimpleBubbingSort extends BaseSort<Double> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mmc.arithmetic.system.sort.BaseSort#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(Double[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}

		int length = arrays.length;
		for (int out = length; out > 0; out--) {// 外层循环控制n个元素比较交换冒出
			for (int in = 0; in < out - 1; in++) { // 内层循环，根据比较规则对相邻元素执行比较交换，最终结果冒出到最后一位
				if (large(arrays[in], arrays[in + 1])) {
					swap(arrays, in, in + 1);
				}
			}
		}
	}

	/**
	 * Description：双向冒泡排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @param arrays
	 */
	public void doubleSort(Double[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}
		int length = arrays.length;
		int out, in;
		int index = 0;
		for (out = length; out > 0; out = out - 2) {
			for (in = 0; in < out - 1; in++) {
				if (large(arrays[in], arrays[in + 1])) {
					swap(arrays, in, in + 1);
				}
			}
			for (index = in - 1; index > 0; index--) {
				if (less(arrays[index], arrays[index - 1])) {
					swap(arrays, index, index - 1);
				}
			}
		}
	}

	/**
	 * Description：奇偶排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * 
	 * @param arrays
	 */
	public void addEvenSort(Double[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}
		int length = arrays.length;
		int out;
		// 奇偶下标
		int uneven = 0;
		int even = 0;

		for (out = length; out > 0; out--) {
			// 奇数下标排序
			for (uneven = 1; uneven < out - 2; uneven = uneven + 2) {
				if (large(arrays[uneven], arrays[uneven + 2])) {
					swap(arrays, uneven, uneven + 2);
				}
			}

			// 偶数下标排序
			for (even = 0; even < out - 2; even = even + 2) {
				if (large(arrays[even], arrays[even + 2])) {
					swap(arrays, even, even + 2);
				}
			}
			
			// 比较冒出的奇偶项
			if (uneven < even) {
				if (large(arrays[uneven], arrays[even])) {
					swap(arrays, uneven, even);
				}
			} else {
				if (large(arrays[even], arrays[uneven])) {
					swap(arrays, even, uneven);
				}
			}
		}
	}
	
	/**
	 * Description：奇偶排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 */
	public void addEvenSort1(Double[] arrays) {
		int length = arrays.length;
		int uneven = 0;
		int even = 0;
		boolean change = true;
		while (change) {
			change = false;
			for (even = 0; even < length - 1; even += 2) {
				if (large(arrays[even], arrays[even + 1])) {
					swap(arrays, even, even + 1);
					change = true;
				}
			}
			
			for (uneven = 1; uneven < length - 1; uneven += 2) {
				if (large(arrays[uneven], arrays[uneven + 1])) {
					swap(arrays, uneven, uneven + 1);
					change = true;
				}
			}
		}
	}
}
