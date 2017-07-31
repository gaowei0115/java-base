// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.stackover;

/** 
 * ClassName: JavaVMStackOfTest<br/>
 * Description: Java虚拟机栈异常<br/>
 * Author: GW<br/>
 * Create： 2017年7月29日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class JavaVMStackOfTest {
	
	/**
	 * 
	 * 测试使用栈深度
	 * 通过配置虚拟机VM参数：-verbose:gc -Xss128k -XX:+PrintGCDetails
	 * 
	 */

	private int stackLength = 1;
	
	public void stackLen() {
		stackLength++;
		stackLen();
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackOfTest vmStackOfTest = new JavaVMStackOfTest();
		try {
			vmStackOfTest.stackLen();
		} catch (Throwable e) {
			System.out.println("stack length:" + vmStackOfTest.stackLength);
			throw e;
		}
	}
}
