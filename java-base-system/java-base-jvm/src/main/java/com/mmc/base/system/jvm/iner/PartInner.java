// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.iner;

/** 
 * ClassName: PartInner<br/>
 * Description: 局部内部类<br/>
 * Author: GW<br/>
 * Create： 2017年9月13日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PartInner {

	/**
	 * 此用例说明为啥使用局部内部类应用外部变量时要将外部变量设置成final类型
	 */
	
	public void fun() {
		final int param = 0;
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("part inner use param final" + param);
			}
		});
		t.start();
	}
}
