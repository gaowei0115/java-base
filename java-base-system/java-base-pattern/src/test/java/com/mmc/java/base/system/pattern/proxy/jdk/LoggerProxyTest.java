// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.mmc.java.base.system.pattern.factory.proxy.jdk.impl.UserManagerImpl;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.Logger;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.LoggerHandler;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.MockLogger;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.SaleManager;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.impl.SaleManagerImpl;

/** 
 * className: LoggerProxyTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LoggerProxyTest {

	@Test
	public void test() {
		Logger logger = new MockLogger(UserManagerImpl.class);
		ClassLoader cl = logger.getClass().getClassLoader();
		Class<?>[] interfaces = logger.getClass().getInterfaces();
		LoggerHandler lh = new LoggerHandler(logger);
		Proxy.newProxyInstance(cl, interfaces, lh);
		
		SaleManager saleManager = new SaleManagerImpl();
		saleManager.addSale();
		saleManager.delSale();
	}
	
	@Test
	public void test01() {
		System.out.println(8 >>> 2);
		System.out.println(2 << 2);
	}
}
