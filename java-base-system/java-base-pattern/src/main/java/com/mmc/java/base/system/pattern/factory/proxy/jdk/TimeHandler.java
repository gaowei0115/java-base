// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * className: TimeHandler<br/>
 * Description: 增加时间代理<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class TimeHandler implements InvocationHandler {

	private final Object target;
	// 时间格式
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public TimeHandler(Object obj) {
		this.target = obj;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start time " + sdf.format(new Date()));
		long start = System.currentTimeMillis();
		method.invoke(target, args);
		long end = System.currentTimeMillis();
		System.out.println("end time " + sdf.format(new Date()) + " cost time " + (end - start) + " ms");
		return null;
	}
	
	

}
