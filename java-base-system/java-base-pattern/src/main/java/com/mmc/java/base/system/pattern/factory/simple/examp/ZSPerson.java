// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple.examp;

/** 
 * ClassName: ZSPerson<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ZSPerson implements Person{

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.examp.Person#eat()
	 */
	public void eat() {
		System.out.println("zhangsan to eat");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.examp.Person#sleep()
	 */
	public void sleep() {
		System.out.println("zhangsan to sleep");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.examp.Person#speak()
	 */
	public void speak() {
		System.out.println("zhangsan to speak");
	}

}
