// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.refect;

/** 
 * className: BusinessService<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class BusinessService implements IService {

	/* (non-Javadoc)
	 * @see com.mmc.base.system.jvm.refect.IService#login(java.lang.String, java.lang.String)
	 */
	@ExceptionAnn("zhangsan")
	public void login(String name, String password) {
		System.out.println("businessService ... start");
		
		System.out.println("businessService ... end");
	}

}
