// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.heap;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
 * className: PermGenHeap<br/>
 * Description: 持久代区参数设置 -XX:NewSize和-XX:MaxNewSize<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class PermGenHeap {

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		try {
			for (i = 1; i < Integer.MAX_VALUE; i++) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(PermGenObject.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					
					public Object intercept(Object obj, Method method, Object[] objs, MethodProxy proxy) throws Throwable {
						return proxy.invoke(obj, objs);
					}
				});
				enhancer.create();
			}
		} catch (Exception e) {
			
		}
	}
	
	static class PermGenObject {
		private byte[] b = new byte[1024 * 1024 * 10];
	}
}
