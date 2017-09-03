// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.method.examp;

/** 
 * ClassName: StrawberryGardener<br/>
 * Description: 草莓工厂类<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class StrawberryGardener implements FruitGardener {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.method.examp.FruitGardener#factory()
	 */
	public Fruit factory() {
		return new Strawberry();
	}

}
