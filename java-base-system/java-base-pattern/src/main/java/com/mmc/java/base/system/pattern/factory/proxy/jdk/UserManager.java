// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk;

import java.util.Map;

/** 
 * className: UserManager<br/>
 * Description: 用户操作接口<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public interface UserManager {

	
	/**
	 * Description：增加用户信息<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param user
	 */
	void addUser(Map<String, String> user);
	
	/**
	 * Description：删除用户信息<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param userId
	 */
	void delUser(String userId);
}
