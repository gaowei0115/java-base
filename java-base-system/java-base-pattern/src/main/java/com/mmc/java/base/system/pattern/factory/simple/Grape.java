// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple;

/** 
 * ClassName: Grape<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Grape implements Fruit {

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.Fruit#plant()
	 */
	public void plant() {
		System.out.println("grapde plant");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.Fruit#grow()
	 */
	public void grow() {
		System.out.println("grapde grow");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.simple.Fruit#harvest()
	 */
	public void harvest() {
		System.out.println("grape harvest");
	}

}
