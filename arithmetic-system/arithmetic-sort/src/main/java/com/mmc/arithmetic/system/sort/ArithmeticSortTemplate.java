// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort;

/** 
 * className: ArithmeticSortTemplate<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月17日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ArithmeticSortTemplate {

	/**
	 * Description: 排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param a
	 */
	public void sort(Comparable[] a) {
		
	}
	
	/**
	 * Description：比较<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param a1
	 * @param a2
	 * @return
	 */
	private boolean less(Comparable a1, Comparable a2) {
		return (a1.compareTo(a2) < 0);
	}
	
	/**
	 * Description：交换数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param a
	 * @param i
	 * @param j
	 */
	public void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * Description：验证数据是否有序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param a
	 * @return
	 */
	public boolean isSort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
