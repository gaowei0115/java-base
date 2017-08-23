// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort.simple;

import java.util.Random;

import com.mmc.arithmetic.system.sort.BaseSort;

/** 
 * className: SimpleSelectorSortTest<br/>
 * Description: 选择排序测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月23日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SimpleSelectorSortTest {

	public static void main(String[] args) {
		BaseSort<Double> sort = new SimpleSelectorSort();
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
		
		arrays = new Double[10000];
		for (int i = 0; i < 10000; i++) {
			arrays[i] = new Random().nextDouble();
		}
		
		System.out.println("选择排序 start....");
		long start = System.currentTimeMillis();
		sort.sort(arrays);
		long end = System.currentTimeMillis();
		System.out.println("选择排序 end cost time " + (end - start) + " ms");
		
		
//		System.out.println("排序结果：");
//		for (Double d : arrays) {
//			System.out.println(d);
//		}
	}
}
