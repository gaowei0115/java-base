// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria;

import java.io.IOException;

/** 
 * ClassName: UnSerializableObject<br/>
 * Description: 非序列化实体测试<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class UnSerializableObject {

	public static void main(String[] args) throws IOException, Exception {
		String destPath = "E:\\bak\\file\\";
		String fileName = "UnPerson.out";
		UnPerson person = new UnPerson();
		person.setName("zhangsan");
		person.setAddress("henan");
		System.out.println(person);
		System.out.println("serializable before " + person.toString());
		
		SerializableObject.serializableObject(destPath, fileName, person);
		
		Object obj = SerializableObject.unSerializableObject(destPath, fileName);		
		System.out.println("serializble after " + obj.toString());
		System.out.println(obj);
	}
}
