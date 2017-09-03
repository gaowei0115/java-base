// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.method.model;

/** 
 * ClassName: MockApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class MockApp {

	public static void main(String[] args) {
		Creator creator = new GeneratorCreator1();
		Product product = creator.getInstance("product1");
		product.fun();
	}
}
