// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.singleton;

/** 
 * className: LazySyncSingleton<br/>
 * Description: 多线程环境懒汉式单例同步模式实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LazySyncSingleton {

	private static LazySyncSingleton instance;
	
	private LazySyncSingleton() {
		
	}
	
	public static synchronized LazySyncSingleton getInstance() {
		if (instance == null) {
			instance = new LazySyncSingleton();
		}
		return instance;
	}
}
