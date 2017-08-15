// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/** 
 * className: RandomAccessFileMock<br/>
 * Description: 随机读取文件RandomAccessFile<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class RandomAccessFileMock {

	public static void main(String[] args) throws IOException {
		String path = new RandomAccessFileMock().getClass().getResource("").getPath();
		
		String pathname = path + "test.txt";
		File file = new File(pathname);
		System.out.println(pathname);
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		byte[] buffer = new byte[1024];
		int pos = 0;
		while ((pos = raf.read(buffer)) != -1) {
			String result = new String(buffer);
			System.out.println(result);
			pos = pos + result.length();
		}
		raf.close();
	}
}
