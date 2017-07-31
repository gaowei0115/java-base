// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.heap;

import java.util.Vector;

/** 
 * className: SettingHeapSize<br/>
 * Description: 设置堆参数 -Xmx指定最大堆分配<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SettingHeapSize {

	/**
	 * Description：-verbose:gc -Xmx10m -Xms10m 指定最大最小堆分配<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Object> vector = new Vector<Object>();
		for (int i = 0; i < 10; i++) {
			byte[] b = new byte[1024 * 1024];// 模拟1M对象数据
			vector.add(b);
			System.out.println(i + "M is allocated");
		}
	}
	
	/**
	 * java.lang.OutOfMemoryError: Java heap space
	at com.mmc.base.system.jvm.heap.SettingHeapSize.main(SettingHeapSize.java:25)
	 */
}
