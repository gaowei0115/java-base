// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.singleton;

/** 
 * className: StaticInerClassSingleton<br/>
 * Description: 使用静态内部类形式实现单例模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StaticInerClassSingleton {

	private StaticInerClassSingleton() {
		
	}
	
	public static StaticInerClassSingleton getInstance() {
		return LazyHandler.instance;
	}
	
	/**
	 * className: LazyHandler<br/>
	 * Description: 内部类实现懒加载<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月22日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	private static class LazyHandler {
		private static final StaticInerClassSingleton instance = new StaticInerClassSingleton();
	}
}
