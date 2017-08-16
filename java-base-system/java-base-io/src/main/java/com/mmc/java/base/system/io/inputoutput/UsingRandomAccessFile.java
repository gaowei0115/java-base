// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.IOException;
import java.io.RandomAccessFile;

/** 
 * ClassName: UsingRandomAccessFile<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月15日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class UsingRandomAccessFile {
	
	static String file = "rtest.txt";
	
	static void display() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println("Value : " + raf.readDouble());
		}
		System.out.println(raf.readUTF());
		raf.close();
	}
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++) {
			raf.writeDouble(i * 1.414);
		}
		
		raf.writeUTF("The end of file.");
		raf.close();
		display();
		raf = new RandomAccessFile(file, "rw");
		raf.seek(5 * 8);
		raf.writeDouble(47.001);
		raf.close();
		display();
	}

}
