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
		for (in = 1; in < length; in++) {
			Double temp = datas[in];
			out = in;
			while (out > 0 && temp <= datas[out - 1]) {
				datas[out] = datas[out - 1];
				out--;
			}
			datas[out] = temp;
		}
	}
	
	public static void swap(Double[] datas, int index, int position) {
		Double temp = datas[index];
		datas[index] = datas[position];
		datas[position] = temp;
	}
	
	public static void main(String[] args) {
		Double[] arrays = new Double[10];
		Double d1 = new Double(42.7);
		Double d2 = new Double(22.3);
		Double d3 = new Double(12.56);
		Double d4 = new Double(20.90);
		Double d5 = new Double(2.7);
		Double d6 = new Double(4.21);
		Double d7 = new Double(10.0);
		Double d8 = new Double(90.12);
		Double d9 = new Double(41.03);
		Double d10 = new Double(23.29);
		
		arrays[0] = d1;
		arrays[1] = d2;
		arrays[2] = d3;
		arrays[3] = d4;
		arrays[4] = d5;
		arrays[5] = d6;
		arrays[6] = d7;
		arrays[7] = d8;
		arrays[8] = d9;
		arrays[9] = d10;
		
		sort(arrays);
		
		for (Double d : arrays) {
			System.out.println(d);
		}
	}
}
