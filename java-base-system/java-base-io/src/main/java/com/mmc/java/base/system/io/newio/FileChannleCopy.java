// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/** 
 * ClassName: FileChannleCopy<br/>
 * Description: 文件拷贝<br/>
 * Author: GW<br/>
 * Create： 2017年8月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class FileChannleCopy {
	
	private static final int SIZE = 1024;

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcpath
	 * @param destpath
	 * @throws IOException 
	 */
	public static void copy(String srcpath, String destpath) throws IOException {
		FileInputStream fis = new FileInputStream(srcpath);
		FileChannel in = fis.getChannel();
		// 缓冲区
		ByteBuffer buff = ByteBuffer.allocate(SIZE);
		FileOutputStream fos = new FileOutputStream(destpath);
		FileChannel out = fos.getChannel();
		while ((in.read(buff)) != -1) {
			buff.flip();
			out.write(buff);
			buff.clear();
		}
		fos.close();
		fis.close();
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcpath
	 * @param destpath
	 * @throws IOException 
	 */
	public static void transferTo(String srcpath, String destpath) throws IOException {
		FileInputStream fis = new FileInputStream(srcpath);
		FileOutputStream fos = new FileOutputStream(destpath);
		
		FileChannel in = fis.getChannel();
		
		FileChannel out = fos.getChannel();
		in.transferTo(0, in.size(), out);
		
		in.close();
		out.close();
		fos.close();
		fis.close();
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String srcpath = "E:\\bak\\file\\file.txt";
		String destpath = "E:\\bak\\filecopy\\filecopy.txt";
		
		// 通过ByteBuffer形式复制文件
//		copy(srcpath, destpath);
		// 通过transfer方式复制文件
		transferTo(srcpath, destpath);
	}
	
}
