// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.method.model;

/** 
 * ClassName: GeneratorCreator1<br/>
 * Description: 具体工厂类<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class GeneratorCreator1 implements Creator {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.method.model.Creator#getInstance(java.lang.String)
	 */
	public Product getInstance(String param) {
		if ("product1".equals(param)) {
			return new GeneratorProduct1();
		}
		return null;
	}

}
