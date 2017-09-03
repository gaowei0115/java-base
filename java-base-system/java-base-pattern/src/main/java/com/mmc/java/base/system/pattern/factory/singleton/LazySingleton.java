// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.singleton;

/** 
 * ClassName: LazySingleton<br/>
 * Description: 懒汉式单例模式<br/>
 * Author: GW<br/>
 * Create： 2017年9月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class LazySingleton {

	private static LazySingleton instance;
	
	private LazySingleton() {
		
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getName() + " > " + LazySingleton.getInstance());
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getName() + " > " + LazySingleton.getInstance());
			}
		}).start();
	}
}
