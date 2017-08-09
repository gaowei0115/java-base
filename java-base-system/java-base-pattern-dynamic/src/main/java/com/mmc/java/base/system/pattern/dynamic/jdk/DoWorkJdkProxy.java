// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * ClassName: DoWorkJdkProxy<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月8日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class DoWorkJdkProxy implements InvocationHandler {

	private final DoWork doWork;
	
	/**
	 * Construtor(@param doWork)
	 * DoWorkJdkProxy.java
	 */
	public DoWorkJdkProxy(DoWork doWork) {
		this.doWork = doWork;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before ....");
		method.invoke(doWork, args);
		System.out.println("after ....");
		return null;
	}

}
