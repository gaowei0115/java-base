// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.insert;

/** 
 * className: InsertSort<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月17日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class InsertSort {

	/**
	 * Description: 排序<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param a
	 */
	public void sort(Double[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j-1])) {
					exch(a, j, j - 1);
				}
			}
		}
		
	}
	
	/**
	 * Description：比较<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param a1
	 * @param a2
	 * @return
	 */
	private boolean less(Double a1, Double a2) {
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
	public void exch(Double[] a, int i, int j) {
		Double t = a[i];
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
	public boolean isSort(Double[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
