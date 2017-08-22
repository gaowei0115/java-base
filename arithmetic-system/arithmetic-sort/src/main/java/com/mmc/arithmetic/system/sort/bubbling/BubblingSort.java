// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.bubbling;

/** 
 * className: BubblingSort<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class BubblingSort {

	/**
	 * Description：整型冒泡排序<br/>
	 * 			时间复杂度分析：循环n2 + 交换 n2
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 */
	public static void bubblingSort(int[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}
		
		// 冒泡排序逻辑
		int length = arrays.length;
		int in , out;// 交互下标
		for (out = length - 1; out >= 0; out--) {
			for (in = 0; in < out; in++) {
				if (arrays[in] > arrays[in + 1]) {
					swap(arrays, in, in + 1);
				}
			}
		}
	}
	
	/**
	 * Description：交换数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 * @param in
	 * @param swin
	 */
	public static void swap(int[] arrays, int in, int swin) {
		int temp = arrays[in];
		arrays[in] = arrays[in + 1];
		arrays[swin] = temp;
	}
	
	public static void main(String[] args) {
		int[] arrays = new int[]{2, 1, 4, 10, 3, 6, 19, 12};
		bubblingSort(arrays);
		for (int i : arrays) {
			System.out.print(i);
			System.out.print(",");
		}	
	}
}
