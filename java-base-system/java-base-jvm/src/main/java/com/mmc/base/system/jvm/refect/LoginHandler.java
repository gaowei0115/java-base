// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.refect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * className: LoginHandler<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LoginHandler implements InvocationHandler {
	
	private final Object target;
	private final String autoName;

	public LoginHandler(Object targetInit, String autoName) {
		this.target = targetInit;
		this.autoName = autoName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			System.out.println("proxy ... start");
			Object result = method.invoke(target, args);
			System.out.println("proxy ... end");
			return result;
		} catch (Throwable e) {
			// 异常处理
			System.out.println(autoName + " exception>>> " + e.getMessage());
		}
		return null;
	}

}
