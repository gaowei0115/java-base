// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future.jdk;

import java.util.concurrent.Callable;

/** 
 * className: RealData<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class RealData implements Callable<String> {

	private String param;
	
	public RealData(String param) {
		this.param = param;
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(param);
			Thread.sleep(100);
		}
		return sb.toString();
	}

}
