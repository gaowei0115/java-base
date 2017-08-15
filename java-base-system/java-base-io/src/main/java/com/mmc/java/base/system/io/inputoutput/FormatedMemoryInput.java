// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/** 
 * className: FormatedMemoryInput<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class FormatedMemoryInput {

	public static void main(String[] args) {
		try {
			String path = new BufferedReaderFile().getClass().getResource("").getPath() + "test.txt";
			DataInputStream dis = new DataInputStream(new ByteArrayInputStream(BufferedReaderFile.read(path).getBytes()));
			while (true) {
				System.out.print((char)dis.readByte());
			}
		} catch (Exception e) {
			
		}
	}
}
