// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.store;

/** 
 * className: ReferenceTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月22日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ReferenceTest {

	private int num;
	
	public void add(ReferenceTest t) {
		ReferenceTest temp = new ReferenceTest();
		temp.num = 10;
		t = temp;
	}
	
	public void add1(ReferenceTest t) {
		t.num = 11;
	}
	
	public static void main(String[] args) {
		ReferenceTest t = new ReferenceTest();
		System.out.println("赋值之前 ： " + t.num);
		t.add(t);
		System.out.println("赋值之后：" + t.num);
		t.add1(t);
		System.out.println(t.num);
	}
}
