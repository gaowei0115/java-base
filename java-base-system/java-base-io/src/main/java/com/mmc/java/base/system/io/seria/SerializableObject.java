// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * ClassName: SerializableObject<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class SerializableObject {

	/**
	 * Description：序列化对象<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param destPath
	 * @param fileName
	 * @param obj
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void serializableObject(String destPath, String fileName, Object obj) throws FileNotFoundException, IOException {
		String path = destPath + fileName;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.close();
	}
	
	/**
	 * Description：反序列化对象<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param destPath
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public static Object unSerializableObject(String destPath, String fileName) throws IOException, IOException, ClassNotFoundException {
		String path = destPath + fileName;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String destPath = "E:\\bak\\file\\";
		String fileName = "Person.out";
		Person person = new Person();
		person.setName("zhangsan");
		person.setAddress("henan");
		person.setPassword("111222233");
		System.out.println(person);
		System.out.println("serializable before " + person.toString());
		
		serializableObject(destPath, fileName, person);
		
		Object obj = unSerializableObject(destPath, fileName);		
		System.out.println("serializble after " + obj.toString());
		System.out.println(obj.getClass());
	}
}
