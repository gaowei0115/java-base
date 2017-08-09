// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.dynamic.jdk;

/** 
 * ClassName: DoWorkImpl<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月8日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class DoWorkImpl implements DoWork {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.dynamic.jdk.DoWork#doWork(java.lang.String)
	 */
	public void doWork(String param) {
		System.out.println("jdk dynamic proxy >>>> " + param);
	}

}
