// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.method;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
 * ClassName: JavaVMMethodAreaOOM<br/>
 * Description: 方法区OOM异常模拟<br/>
 * Author: GW<br/>
 * Create： 2017年7月29日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class JavaVMMethodAreaOOM {

	/**
	 * -verbose:gc -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
	 */
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}
	
	/**
	 * ClassName: OOMObject<br/>
	 * Description: 模拟对象<br/>
	 * Author: GW<br/>
	 * Create： 2017年7月29日<br/>
	 *
	 * History: (Version) Author dateTime description <br/>
	 */
	static class OOMObject {
		
	}
}
