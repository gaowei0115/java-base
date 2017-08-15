// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.IOException;
import java.io.StringReader;

/** 
 * className: MemoryInput<br/>
 * Description: 从内存中输入<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MemoryInput {

	/**
	 * Description：从内存中读取加载的流信息<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String path = new BufferedReaderFile().getClass().getResource("").getPath() + "test.txt";
		StringReader sr = new StringReader(BufferedReaderFile.read(path));
		int c;
		while ((c = sr.read()) != -1) {
			System.out.print((char)c);
		}
	}
}
