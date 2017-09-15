// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.refect;

/** 
 * className: LoginService<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class UserService implements IService {

	/* (non-Javadoc)
	 * @see com.mmc.base.system.jvm.refect.IService#login(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("null")
	@ExceptionAnn("lisi")
	public void login(String name, String password) throws MockException {
		System.out.println("userservice ....start");
		
		// 模拟抛出异常
		try {
			String str = null;
			str.indexOf(1);
		} catch (Exception e) {
			throw new MockException("UserService.login异常");
		}
		
		
		System.out.println("userservice ....end");
	}

}
