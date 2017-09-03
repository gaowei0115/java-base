// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.abstrac.model;

/** 
 * ClassName: Product2Factory<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Product2Factory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.abstrac.model.AbstractFactory#getProduct1()
	 */
	@Override
	public AbstractProduct1 getProduct1() {
		return new CurrentProduct12();
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.abstrac.model.AbstractFactory#getProduct2()
	 */
	@Override
	public AbstractProduct2 getProduct2() {
		return new CurrentProcut22();
	}

}
