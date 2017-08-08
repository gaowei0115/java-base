// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/** 
 * className: ReflectObation<br/>
 * Description: 反射机制实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ReflectObation {

	public static void main(String[] args) {
		ReflectClass reflect = new ReflectClass("desc", 1);
		reflect.getInfo();
		try {
			Constructor<ReflectClass> constructor = ReflectClass.class.getConstructor(String.class, Integer.class);
			ReflectClass reflectClass = constructor.newInstance("desc1", 3);
			Method[] methods = ReflectClass.class.getMethods();
			Method method = null;
			for (Method m : methods) {
//				System.out.println(m.getName());
				if ("getInfo".equals(m.getName())) {
					method = m;
					System.out.println(method);
				}
			}
			
			method.invoke(reflectClass);
			
		} catch (Exception e) {
			
		}
	}
}
