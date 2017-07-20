// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker;

/** 
 * className: PlusWorker<br/>
 * Description: 计算1-100立方求和<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class PlusWorker extends Worker {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.thread.masterworker.Worker#handle(java.lang.Object)
	 */
	@Override
	public Object handle(Object input) {
		Integer i = (Integer)input;
		return i * i * i;
	}
}
