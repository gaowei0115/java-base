// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort;

/** 
 * className: BaseSort<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public abstract class BaseSort<T extends Comparable<T>> {

	/**
	 * Description：排序规则<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 */
	public abstract void sort(T[] arrays);
	
	/**
	 * Description：交换数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 * 			数组
	 * @param index
	 * 			下标
	 * @param swindex
	 */
	public void swap(T[] arrays, int index, int swindex) {
		T temp = arrays[index];
		arrays[index] = arrays[swindex];
		arrays[swindex] = temp;
	}
	
	/**
	 * Description：从小到大排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param d1
	 * @param d2
	 * @return
	 */
	protected boolean less(T d1, T d2) {
		return d1.compareTo(d2) < 0;
	}
	
	/**
	 * Description：从大到小排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param d1
	 * @param d2
	 * @return
	 */
	protected boolean large(T d1, T d2) {
		return d1.compareTo(d2) > 0;
	}
	
	/**
	 * Description：验证排序规则是否是从小到大规则<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 * @return
	 */
	public boolean isLessSort(T[] arrays){
		for (int i = 0; i < arrays.length - 1; i++) {
			if (!less(arrays[i], arrays[i + 1])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Description：验证是否从大到小排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arrays
	 * @return
	 */
	public boolean isLargeSort(T[] arrays) {
		for (int i = 0; i < arrays.length - 1; i++) {
			if (!large(arrays[i], arrays[i + 1])) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
