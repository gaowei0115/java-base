// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple.examp;

/** 
 * ClassName: PersonFactory<br/>
 * Description: 产生人对象工厂<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PersonFactory {

	/**
	 * Description：工厂方法<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param personId
	 * @return
	 * @throws NoObjectException
	 */
	public static Person getInstance(String personId) throws NoObjectException {
		if ("lisi".equals(personId)) {
			return new LSPerson();
		} else if ("zhangsan".equals(personId)) {
			return new ZSPerson();
		} else {
			throw new NoObjectException("没有对应的对象....");
		}
	}
}
