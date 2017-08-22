// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.compress;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/** 
 * ClassName: MoreGzipCompress<br/>
 * Description: 多个文件压缩<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class MoreGzipCompress {

	public enum CompressEnum {
		GZIP("01", ".gz"),
		ZIP("02", ".zip");
		
		private String code;
		private String value;
		
		private CompressEnum(String codeInit, String valueInit) {
			this.code = codeInit;
			this.value = valueInit;
		}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		
	}
	
	/**
	 * Description：压缩多个文件<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcPaths
	 * 			源文件数组
	 * @param destPath
	 * 			压缩目标文件
	 * @throws IOException 
	 */
	public static void compressGzip(String srcPath, String[] srcFileNames, String destPath, String destName) throws IOException {
		destPath = String.format("%s\\%s%s", destPath, destName, CompressEnum.GZIP.getValue());
		if (srcFileNames != null && srcFileNames.length > 0) {
			BufferedReader br;
			FileOutputStream fos = new FileOutputStream(destPath);
			CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32());
			ZipOutputStream zos = new ZipOutputStream(cos);
			BufferedOutputStream bos = new BufferedOutputStream(zos);
			zos.setComment("a testing java more compress");
			for (String fileName : srcFileNames) {
				System.out.println("compress file " + srcPath);
				br = new BufferedReader(new FileReader(srcPath + "\\" + fileName));
				zos.putNextEntry(new ZipEntry(fileName));
				int s;
				while ((s = br.read()) != -1) {
					bos.write(s);
				}
				br.close();
				bos.flush();
			}
			bos.close();
		}
		
	}
	
	/**
	 * Description：单个文件执行压缩流<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param srcPath
	 * @param out
	 * @throws IOException
	 */
	public static void compressSingleFile(String srcPath, String fileName, BufferedOutputStream out) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(srcPath + "\\" + fileName));
		int s;
		while ((s = br.read()) != -1) {
			out.write(s);
		}
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		String srcPath = "E:\\bak\\file";
		String[] fileNames = new String[]{"file.txt", "mapped.txt", "nature.txt"};
		String destPath = "E:\\bak\\file";
		compressGzip(srcPath, fileNames, destPath, "test");
	}
}
