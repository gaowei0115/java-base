// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mmc.arithmetic.system.sort.insert.InsertSort;

/** 
 * className: InsertSortMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月17日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class InsertSortMain {

	public static void main(String[] args) throws IOException {
		System.out.print("input : ");
		Double[] ddd = readDoubleArray();
		new InsertSort().sort(ddd);
		
		for (Double d : ddd) {
			System.out.print(d);
			System.out.print(",");
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 * @throws IOException
	 */
	public static String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		return input;
	}
	
	public static Double[] readDoubleArray() throws IOException {
		String input = getString();
		String[] arrayStr = input.split(",");
		Double[] dArr = new Double[arrayStr.length];
		int i = 0;
		for (String s : arrayStr) {
			dArr[i++] = Double.valueOf(s);
		}
		return dArr;
	}
}
