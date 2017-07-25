// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.volatil;

/** 
 * ClassName: VolatileMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月24日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class VolatileMain {

	public static void main(String[] args) throws Exception {
		VolatileThread volatileThread = new VolatileThread();
		volatileThread.start();
		Thread.sleep(100);
		volatileThread.subStop();
		System.out.println("=====================================");
		Thread.sleep(100);
	}
}
