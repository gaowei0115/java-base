// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.heapoutof;

import java.util.ArrayList;
import java.util.List;

/** 
 * className: OutOfMemoryTest<br/>
 * Description: 堆溢出测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月28日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class HeapOutOfMemoryTest {

	
	/**
	 * -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
	 */
	
	
	/**
	 * Description：测试入口<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		List<HeapClass> list = new ArrayList<HeapOutOfMemoryTest.HeapClass>();
		while (true) {
			list.add(new HeapClass());
		}
	}
	
	/**
	 * className: HeapClass<br/>
	 * Description: 模拟对象<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年7月28日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class HeapClass {
		
	}
}
