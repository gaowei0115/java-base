// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.method;

import java.util.ArrayList;
import java.util.List;

/** 
 * className: RuntimeConstantPoolOOM<br/>
 * Description: 运行时常量池数据OOM异常模拟<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i).intern());
		}
	}
	/**
	 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
			at java.util.Arrays.copyOf(Arrays.java:3210)
			at java.util.Arrays.copyOf(Arrays.java:3181)
			at java.util.ArrayList.grow(ArrayList.java:261)
			at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
			at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
			at java.util.ArrayList.add(ArrayList.java:458)
			at com.mmc.base.system.jvm.method.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:21)
		Java HotSpot(TM) Client VM warning: ignoring option PermSize=10M; support was removed in 8.0
		Java HotSpot(TM) Client VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
	 */
}
