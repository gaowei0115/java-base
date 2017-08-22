// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.api.singleton;

/** 
 * className: DoubleSyncSingleton<br/>
 * Description: 双重加锁模式实现懒汉式单例模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DoubleSyncSingleton {

	/**
	 * 使用volatile修饰，保证每次获取的都是内存中最新对象
	 */
	private static volatile DoubleSyncSingleton instance;
	
	private DoubleSyncSingleton() {
		
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static DoubleSyncSingleton getInstance() {
		if (instance == null) {
			synchronized(DoubleSyncSingleton.class) {
				if (instance == null) {
					instance = new DoubleSyncSingleton();
				}
			}
		}
		return instance;
	}
}
