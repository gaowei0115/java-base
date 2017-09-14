// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.refect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * className: ReflectService<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ProxyServiceFactory {

	private static final String packageName = "com.mmc.base.system.jvm.refect";
	private static final ConcurrentHashMap<Class<?>, IService> classRelation = new ConcurrentHashMap<Class<?>, IService>();
	
	
	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Class<?> clazz = classLoader.loadClass(packageName);
			if (clazz != null) {
				Method[] methods = clazz.getMethods();
				if (methods != null && methods.length > 0) {
					for (Method m : methods) {
						ExceptionAnn ann = m.getAnnotation(ExceptionAnn.class);
						if (ann != null) {
							String value = ann.value();
							System.out.println(clazz + " : " + value);
							Object iService = clazz.newInstance();
							if (iService instanceof IService) {
								Class<?>[] interfaces = clazz.getInterfaces();
								ClassLoader cl = clazz.getClassLoader();
								InvocationHandler ih = new LoginHandler(clazz.newInstance(), value);
								IService is = (IService) Proxy.newProxyInstance(cl, interfaces, ih);
								classRelation.put(clazz, is);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param obj
	 * @return
	 */
	public static IService proxyIService(Object obj) {
		return classRelation.get(obj.getClass());
	}
}
