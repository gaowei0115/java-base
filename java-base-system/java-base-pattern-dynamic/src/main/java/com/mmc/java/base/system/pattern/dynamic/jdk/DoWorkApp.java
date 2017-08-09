// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.dynamic.jdk;

import java.lang.reflect.Proxy;

/** 
 * ClassName: DoWorkApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月8日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class DoWorkApp {

	public static void main(String[] args) {
		DoWork doWork = new DoWorkImpl();
		DoWork doWork1 = (DoWork) Proxy.newProxyInstance(doWork.getClass().getClassLoader(), doWork.getClass().getInterfaces(), new DoWorkJdkProxy(doWork));
		doWork1.doWork("nihao");
	}
}
