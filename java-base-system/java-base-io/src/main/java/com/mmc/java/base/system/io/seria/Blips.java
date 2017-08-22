// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * ClassName: Blips<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Blips {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String file = "E:\\bak\\file\\Blips.out";
		Blip1 blip1 = new Blip1();
		Blip2 blip2 = new Blip2();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		System.out.println("saving object ");
		oos.writeObject(blip1);
		oos.writeObject(blip2);
		
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		System.out.println("recovering object ");
		blip1 = (Blip1) ois.readObject();
		blip2 = (Blip2) ois.readObject();
		
		ois.close();
	}
}
