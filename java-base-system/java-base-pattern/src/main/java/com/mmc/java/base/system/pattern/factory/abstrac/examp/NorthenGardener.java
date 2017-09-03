// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.abstrac.examp;

/** 
 * ClassName: NorthenGardener<br/>
 * Description: 北方作物园丁工厂<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class NorthenGardener extends AbstractGardener {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.abstrac.examp.AbstractGardener#getFruit()
	 */
	@Override
	public AbstractFruit getFruit() {
		return new NorthenFruit();
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.abstrac.examp.AbstractGardener#getVeggle()
	 */
	@Override
	public AbstractVeggle getVeggle() {
		return new NorthenVeggle();
	}

}
