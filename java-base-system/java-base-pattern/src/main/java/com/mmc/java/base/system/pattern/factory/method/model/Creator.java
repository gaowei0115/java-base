// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.method.model;

/** 
 * ClassName: Creator<br/>
 * Description: 工厂接口<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public interface Creator {

	public Product getInstance(String param);
}
