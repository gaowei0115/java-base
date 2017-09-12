// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mmc.java.base.system.pattern.factory.proxy.jdk.TimeHandler;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.TransactionManagerHandler;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.UserManager;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.impl.UserManagerImpl;

/** 
 * className: TransactionManagerProxyTester<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class TransactionManagerProxyTester {

	@Test
	public void test() {
		
		UserManager userManager = new UserManagerImpl();
		
		TransactionManagerHandler tmh = new TransactionManagerHandler(userManager);
		
		ClassLoader loader = userManager.getClass().getClassLoader();
		Class<?>[] interfaces = userManager.getClass().getInterfaces();
		
		UserManager manager = (UserManager) Proxy.newProxyInstance(loader, interfaces, tmh);
		
		TimeHandler th = new TimeHandler(manager);
		manager = (UserManager) Proxy.newProxyInstance(loader, interfaces, th);
		
		//
		Map<String, String> user = new HashMap<String, String>();
		user.put("userId", "1000");
		user.put("userName", "zhangsan");
		user.put("password", "111222");
		manager.addUser(user);
		
		System.out.println("============================");
		manager.delUser("1000");
	}
}
