// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** 
 * ClassName: SearchSerialiableClass<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SearchSerialiableClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String destPath = "E:\\bak\\file\\Person.out";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destPath));
		Object obj = ois.readObject();
		System.out.println(obj);
		System.out.println(obj.getClass());
		ois.close();
	}
}
