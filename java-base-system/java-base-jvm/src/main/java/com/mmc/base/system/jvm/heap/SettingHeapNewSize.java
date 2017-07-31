// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.heap;

import java.util.Vector;

/** 
 * className: SettingHeapNewSize<br/>
 * Description: 设置堆参数，-Xmn和（-XX:NewSize和-XX:MaxNewSize）都可以（设置新生代空间）<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SettingHeapNewSize {

	/**
	 * Description：-verbose:gc -Xmx10M -Xms3M -Xmn3M<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Object> vector = new Vector<Object>();
		int i = 0;
		do {
			byte[] b = new byte[1024 * 1024];
			vector.add(b);
			if (vector.size() == 3) {
				// 等于3的倍数时，清空
				vector.clear();
			}
			i++;
		} while (i < 1000);
	}
}
