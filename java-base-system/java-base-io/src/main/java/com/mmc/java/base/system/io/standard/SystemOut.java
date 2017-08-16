// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.standard;

import java.io.PrintWriter;

/** 
 * ClassName: SystemOut<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月16日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SystemOut {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.write("hello printWrite");
		
		pw.println("helo println");
		pw.close();
	}
}
