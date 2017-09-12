// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * className: LoggerHandler<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LoggerHandler implements InvocationHandler {
	
	public static Logger logger = new MockLogger(LoggerHandler.class);

	private final Object target;
	
	public LoggerHandler(Object obj) {
		this.target = obj;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (AnnotationProduce.validateMethod(method.getName())) {
			logger.debug("开始执行.....");
			method.invoke(target, args);
			logger.debug("结束执行....");
		} else {
			method.invoke(target, args);
		}
		return null;
	}

}
