// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** 
 * className: BufferedReaderFile<br/>
 * Description: 缓冲区读取文件<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class BufferedReaderFile {

	/**
	 * Description：BufferedReader缓存区读取文件<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String read(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String s;
		StringBuffer sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		String path = new BufferedReaderFile().getClass().getResource("").getPath() + "test.txt";
		String result = read(path);
		System.out.println(result);
	}
}
