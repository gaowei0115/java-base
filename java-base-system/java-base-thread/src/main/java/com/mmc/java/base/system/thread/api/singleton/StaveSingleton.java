// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.singleton;

/** 
 * className: StaveSingleton<br/>
 * Description: 饿汉式单例模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StaveSingleton {

	private static final StaveSingleton instance = new StaveSingleton();
	
	private StaveSingleton() {
		
	}
	
	public static StaveSingleton getInstance() {
		return instance;
	}
}
