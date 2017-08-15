// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 * ClassName: StoringAndRecoveringData<br/>
 * Description: 存储恢复数据<br/>
 * Author: GW<br/>
 * Create： 2017年8月15日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class StoringAndRecoveringData {

	/**
	 * Description：存储恢复数据<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param path
	 * @throws IOException
	 */
	public static void storingAndRecovering(String path) throws IOException {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
		dos.writeDouble(123.3);
		dos.writeUTF("that was api");
		dos.writeDouble(1.421);
		dos.writeUTF("Square root of 2");
		dos.close();
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		dis.close();
	}
	
	public static void main(String[] args) throws IOException {
		String path = new StoringAndRecoveringData().getClass().getResource("").getPath() + "Data.txt";
		storingAndRecovering(path);
	}
}
