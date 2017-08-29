// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.high.has;

/** 
 * className: HashSort<br/>
 * Description: 哈希排序算法<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月29日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class HashSort {

	/**
	 * Description：哈希算法实现原理<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param datas
	 */
	public static void sort(Double[] datas) {
		int in, out;
		int h = 1;
		// 计算hash值
		int length = datas.length;
		while (h <= length / 3) {
			h = h * 3 + 1;
		}
		
		while (h > 0) {
			for (out = h; out < length; out++) {
				Double temp = datas[out];
				in = out;
				while (in > h - 1 && datas[in - h] >= temp) {
					datas[in] = datas[in - h];
					in = in - h;
				}
				datas[in] = temp;
			}
			h = (h - 1) / 3;
		}
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
