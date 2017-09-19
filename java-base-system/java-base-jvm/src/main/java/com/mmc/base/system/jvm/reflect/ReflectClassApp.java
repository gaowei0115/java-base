// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.mmc.base.system.jvm.reflect.impl.ReflectServiceImpl;

/** 
 * ClassName: ReflectClassApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ReflectClassApp {

	@Test
	public void test01() throws ClassNotFoundException, Exception, IllegalAccessException {
		Class<?> clazz1 = Class.forName("com.mmc.base.system.jvm.reflect.impl.ReflectServiceImpl");
		Class<?> clazz2 = ReflectServiceImpl.class;
		Class<?> clazz3 = new ReflectServiceImpl().getClass();
		
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		
		Class<?> clazz = clazz1.getSuperclass();
		System.out.println(clazz);
		
		Class<?>[] interfaces = clazz1.getInterfaces();
		for (Class<?> c : interfaces) {
			System.out.println(c);
		}
		
		ReflectServiceImpl reflectServiceImpl = (ReflectServiceImpl) clazz1.newInstance();
		System.out.println(reflectServiceImpl.Default_Value);
		
		Field[] fields = clazz1.getDeclaredFields();
		for (Field fd : fields) {
			System.out.println(fd.getName());
		}
		
		System.out.println("method:::");
		Method[] methods = clazz1.getMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
		
	}
	
	@Test
	public void test02() throws Exception {
		Class<?> clazz = Class.forName("com.mmc.base.system.jvm.reflect.impl.ReflectServiceImpl");
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			if ("add".equals(m.getName())) {
				m.invoke(clazz.newInstance(), null);
			}
		}
	}
}
