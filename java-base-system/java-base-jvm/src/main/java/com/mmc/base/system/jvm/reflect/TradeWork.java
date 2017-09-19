// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.reflect;

/** 
 * ClassName: TradeWork<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public abstract class TradeWork implements Work{

	/* (non-Javadoc)
	 * @see com.mmc.base.system.jvm.reflect.Work#doWork()
	 */
	public void doWork() {
		this.call();
	}
	
	
}
