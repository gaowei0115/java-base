// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.standard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** 
 * ClassName: SystemIn<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月16日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SystemIn {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input : ");
		String s ;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while ((s = br.readLine()) != null && s.length() != 0) {
			bw.write(s.toUpperCase());
			System.out.println("result >>> " + s);
		}
		
		br.close();
		bw.close();
	}
}
