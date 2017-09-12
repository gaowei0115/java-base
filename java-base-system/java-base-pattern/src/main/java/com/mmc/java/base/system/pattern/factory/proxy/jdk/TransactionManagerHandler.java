// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * className: UserManagerHandler<br/>
 * Description: 模拟事务动态代理实现类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class TransactionManagerHandler implements InvocationHandler {

	private final Object target;
	
	/**
	 * @param obj
	 */
	public TransactionManagerHandler(Object obj) {
		target = obj;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开启事务....");
		try {
			method.invoke(target, args);
		} catch (Exception e) {
			System.err.println("事务回滚....");
		}
		System.out.println("事务执行结束....");
		return null;
	}


}
