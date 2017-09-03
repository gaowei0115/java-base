// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple.examp1;

/** 
 * ClassName: Square<br/>
 * Description: 方形<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Square extends Graph {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.examp1.Graph#draw()
	 */
	@Override
	public void draw() {
		System.out.println("draw square");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.examp1.Graph#erase()
	 */
	@Override
	public void erase() {
		System.out.println("erase square");
	}

}
