// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.singleton;

/** 
 * ClassName: ConfigManagerApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ConfigManagerApp {

	public static void main(String[] args) {
		ConfigManager instance = ConfigManager.getInstance();
		Object result = instance.getConfigItem("singleton.password", "key");
		System.out.println(result);
	}
}
