// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/** 
 * ClassName: LargeMappedFiles<br/>
 * Description: MappedByteBuffer内存映射方式读取文件<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class LargeMappedFiles {

	static int length = 0x8FFFFFF; // 128M
	
	public static void main(String[] args) throws IOException {
		String path = "E:\\bak\\file\\file.txt";
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		FileChannel fc = raf.getChannel();
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			mbb.put((byte)'x');
		}
		mbb.flip();
		System.out.println("finished writing ");
		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.println((char)mbb.get());
		}
		
	}
}
