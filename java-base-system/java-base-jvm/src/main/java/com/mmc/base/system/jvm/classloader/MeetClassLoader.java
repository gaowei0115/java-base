// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.classloader;

/** 
 * className: MeetClassLoader<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MeetClassLoader {

	public static void main(MockString[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader());
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			System.out.println("通过当前线程获取classLoader加载类");
			Class<?> clazz = classLoader.loadClass("com.mmc.base.system.jvm.classloader.MeetClassLoader");
			System.out.println(clazz);
			System.out.println(clazz.newInstance());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
