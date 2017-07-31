// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.heap;

/** 
 * ClassName: HeapGcTest<br/>
 * Description: heap垃圾回收测试<br/>
 * Author: GW<br/>
 * Create： 2017年7月31日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class HeapGcTest {

	private static final int one_mb = 1024 * 1024;
	
	/**
	 * Description：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * one_mb];
		allocation2 = new byte[2 * one_mb];
		allocation3 = new byte[4 * one_mb];
		allocation4 = new byte[4 * one_mb];
	}
	
	public static void main(String[] args) {
		testAllocation();
	}
	
	/**
	 * Heap
 PSYoungGen      total 9216K, used 5244K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 64% used [0x00000000ff600000,0x00000000ffb1f070,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 ParOldGen       total 10240K, used 8192K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 80% used [0x00000000fec00000,0x00000000ff400020,0x00000000ff600000)
 Metaspace       used 2670K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 288K, capacity 386K, committed 512K, reserved 1048576K
	 */
}
