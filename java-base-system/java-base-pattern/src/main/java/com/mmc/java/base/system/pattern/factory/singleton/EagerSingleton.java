// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.singleton;

/** 
 * ClassName: EagerSingleton<br/>
 * Description: 饿汉式单例模式<br/>
 * Author: GW<br/>
 * Create： 2017年9月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class EagerSingleton {

	private static final EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton() {
		
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public static EagerSingleton getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println(EagerSingleton.getInstance());
		System.out.println(EagerSingleton.getInstance());
	}
}
