// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.constantpool;

import java.util.ArrayList;
import java.util.List;

/** 
 * ClassName: RuntimeConstantPoolOOM<br/>
 * Description: 运行时常量池发生OOM异常<br/>
 * Author: GW<br/>
 * Create： 2017年7月29日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class RuntimeConstantPoolOOM {

	/**
	 * 运行时常量池位于方法区中，设置常量池大小通过：-XX:PermSize和-XX:MaxPermSize限制
	 * -XX:PermSize=10M -XX:MaxPermSize=10
	 * -verbose:gc -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
	 */
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		long i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
