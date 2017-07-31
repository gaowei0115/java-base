// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.heap;

import java.util.Vector;

/** 
 * className: SettingHeapSizeSmall<br/>
 * Description: 设置堆参数 -Xms 指定最小堆<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SettingHeapSizeSmall {

	/**
	 * Description：设置堆 -Xms为3M<br/>
	 * 	-verbose:gc -Xms3M -XX:+PrintGCDetails
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
	
	/**[GC (Allocation Failure)  3556K->3556K(5060K), 0.0004607 secs]
	[Full GC (Allocation Failure)  3556K->1508K(5060K), 0.0014047 secs] // gc回收
	[GC (Allocation Failure)  2532K->2532K(4032K), 0.0004000 secs]
	[GC (Allocation Failure)  3556K->2532K(4032K), 0.0000892 secs]
	[GC (Allocation Failure)  3556K->3556K(5060K), 0.0003262 secs]
	[Full GC (Allocation Failure)  3556K->1508K(5060K), 0.0012673 secs]
		 * 
		 */
}
