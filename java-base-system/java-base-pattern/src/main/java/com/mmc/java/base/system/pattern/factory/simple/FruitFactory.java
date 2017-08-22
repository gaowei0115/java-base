// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple;

/** 
 * ClassName: FruitFactory<br/>
 * Description: 水果简单工厂模式实现<br/>
 * Author: GW<br/>
 * Create： 2017年8月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class FruitFactory {

	/**
	 * Description：工厂模式方法<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param which
	 * @return
	 */
	public static Fruit getInstance(String which) {
		if (FruitEnum.APPLE.getMark().equals(which)) {
			return new Apple();
		} else if (FruitEnum.GRAPE.getMark().equals(which)) {
			return new Grape();
		}
		return null;
	}
	
	static enum FruitEnum{
		APPLE("apple", "apple type"),
		GRAPE("grape", "grape type");
		
		private String mark;
		private String value;
		
		private FruitEnum(String markinit, String valueinit) {
			this.mark = markinit;
			this.value = valueinit;
		}

		/**
		 * @return the mark
		 */
		public String getMark() {
			return mark;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
	}
}
