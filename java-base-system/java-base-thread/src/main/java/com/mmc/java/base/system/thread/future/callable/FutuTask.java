// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future.callable;

import java.util.concurrent.Callable;

/** 
 * className: FutuTask<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月7日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class FutuTask implements Callable<String> {

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() throws Exception {
		return "test";
	}

}
