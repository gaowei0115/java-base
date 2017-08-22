// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.compress;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/** 
 * ClassName: GzipCompress<br/>
 * Description: gzip压缩<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class GzipCompress {

	public static void main(String[] args) throws IOException {
		// 读文件入口
		String srcFile = "E:\\bak\\file\\file.txt";
		String destFile = "E:\\bak\\file\\1.gz";
		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(destFile)));
		System.out.println("writing gzip file ");
		int c;
		while ((c = br.read()) != -1) {
			bos.write(c);
		}
		
		br.close();
		bos.close();
		
		System.out.println("readiing gzip file ");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(destFile))));
		String s;
		while ((s = in.readLine()) != null) {
			System.out.println(s);
		}
		in.close();
		
	}
}
