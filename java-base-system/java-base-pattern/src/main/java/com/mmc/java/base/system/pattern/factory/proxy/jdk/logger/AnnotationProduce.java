// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.logger;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/** 
 * className: AnnotationProduce<br/>
 * Description: 注解处理<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AnnotationProduce {
	
	private final static Set<String> classNames = new HashSet<String>();
	
	private final static Set<String> methods = new HashSet<String>();
	
	static {
		String packagePath = AnnotationProduce.class.getPackage().getName();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String pph  =packagePath.replace(".", "/");
		URL url = classLoader.getResource(pph);
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
							classNames.add(packagePath + "." + fileName.replaceAll(".class", ""));
						}
					}
				}
			}
		}
		
		for (String cn : classNames) {
			try {
				Class<?> clazz = classLoader.loadClass(cn);
				if (clazz != null) {
					Method[] ms = clazz.getMethods();
					if (ms != null && ms.length > 0) {
						for (Method m : ms) {
							String name = m.getName();
							if (m.isAnnotationPresent(PointC.class)) {
//								PointC pointC = m.getAnnotation(PointC.class);
//								String value = pointC.value();
								methods.add(name);
							}
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean validateMethod(String methodName) {
		if (methods.contains(methodName)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		for (String cn : classNames) {
			System.out.println(cn);
		}
		
	}
}
