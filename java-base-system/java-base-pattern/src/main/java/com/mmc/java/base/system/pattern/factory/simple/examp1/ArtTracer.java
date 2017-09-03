// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple.examp1;

/** 
 * ClassName: ArtTracer<br/>
 * Description: 扫描员工厂类，用于创建不同的形状对象<br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ArtTracer {

	/**
	 * Description：工厂方法<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param id
	 * @return
	 * @throws BadShapeException
	 */
	public static Graph getInstance(String id) throws BadShapeException {
		if ("circle".equals(id)) {
			return new Circle();
		} else if ("square".equals(id)) {
			return new Square();
		} else if ("triangle".equals(id)) {
			return new Triangle();
		} else {
			throw new BadShapeException("not exist type ：" + id + " object.");
		}
	}
}
