// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern;

import org.junit.Test;

import com.mmc.java.base.system.pattern.factory.simple.Fruit;
import com.mmc.java.base.system.pattern.factory.simple.FruitFactory;

/** 
 * ClassName: FruitFctoryTest<br/>
 * Description: 简单工厂模式测试<br/>
 * Author: GW<br/>
 * Create： 2017年8月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class FruitFctoryTest {
	
	@Test
	public void test01() {
		Fruit fruit = FruitFactory.getInstance("apple");
		fruit.plant();
		fruit.grow();
		fruit.harvest();
	}
	
	@Test
	public void test02() {
		Fruit fruit = FruitFactory.getInstance("grape");
		fruit.plant();
		fruit.grow();
		fruit.harvest();
	}
	
}
