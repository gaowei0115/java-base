// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple.examp;

/** 
 * ClassName: PersonFactoryTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PersonFactoryTest {

	public static void main(String[] args) throws NoObjectException {
		Person p = PersonFactory.getInstance("zhangsan");
		p.eat();
		p.sleep();
		p.speak();
	}
}
