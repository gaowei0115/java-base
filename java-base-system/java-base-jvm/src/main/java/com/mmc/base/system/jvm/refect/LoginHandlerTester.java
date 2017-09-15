// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.refect;

/** 
 * className: LoginHandlerTester<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LoginHandlerTester {

	public static void main(String[] args) throws MockException {
		IService service = ProxyServiceFactory.proxyIService(new UserService());
		service.login("user", "password");
	}
}
