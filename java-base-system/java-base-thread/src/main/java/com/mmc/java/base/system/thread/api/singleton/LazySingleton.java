// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.singleton;

/** 
 * className: LazySingleton<br/>
 * Description: 懒汉式单例模式（非线程安全）<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class LazySingleton {

	private static LazySingleton instance = new LazySingleton();
	
	private LazySingleton() {
		
	}
	
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
