// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.refect;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
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

	public static final String DEFAULT_PACKAGE_NAME = "com.mmc.base.system.jvm.refect";
	private static final ConcurrentHashMap<String, IService> classRelation = new ConcurrentHashMap<String, IService>();
	
	static {
		Set<String> classNames = new HashSet<String>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String basePackage = IService.class.getPackage().getName();
		getClassPackage(basePackage, classLoader, classNames);
		
		try {
			for (String pn : classNames) {
				Class<?> clazz = classLoader.loadClass(pn);
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
									classRelation.put(clazz.getName(), is);
								}
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
	 * @param basePackage
	 * @param classNames
	 */
	public static void getClassPackage(String basePackage, ClassLoader classLoader, Set<String> classNames) {
		String urlPackage = basePackage.replace(".", "/");
		URL url = classLoader.getResource(urlPackage);
		if (url != null) {
			String protocol = url.getProtocol();
			String path = url.getPath();
			if ("file".equals(protocol)) {
				File file = new File(path);
				File[] files = file.listFiles();
				for (File f : files) {
					if (!f.isDirectory()) {
						String fileName = f.getName();
						if (fileName.endsWith(".class") && !fileName.contains("$")) {
							classNames.add(basePackage + "." + fileName.replaceAll(".class", ""));
						}
					} else {
						String packageName = basePackage.concat(".").concat(f.getName());
						getClassPackage(packageName, classLoader, classNames);
					}
				}
			}
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
		return classRelation.get(obj.getClass().getName());
	}
}
