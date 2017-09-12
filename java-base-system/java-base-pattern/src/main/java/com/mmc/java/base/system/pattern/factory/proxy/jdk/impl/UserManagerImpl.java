// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.impl;

import java.util.Map;

import com.mmc.java.base.system.pattern.factory.proxy.jdk.UserManager;

/** 
 * className: UserManagerImpl<br/>
 * Description: 用户管理<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class UserManagerImpl implements UserManager {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.UserManager#addUser(java.util.Map)
	 */
	public void addUser(Map<String, String> user) {
		System.out.println("增加用户信息start.....");
		for (String key : user.keySet()) {
			try {
				// 模拟业务执行耗时
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(key + " : " + user.get(key));
		}
		System.out.println("增加用户信息end.....");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.UserManager#delUser(java.lang.String)
	 */
	public void delUser(String userId) {
		System.out.println("删除用户信息start......");
		System.out.println("delete userId : " + userId);
		System.out.println("删除用户信息end......");
	}

}
