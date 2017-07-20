// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** 
 * className: NioFileCopy<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class NioFileCopy {

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param srcPath
	 * @param destPath
	 */
	public static void fileCopy(String srcPath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcPath);
			fos = new FileOutputStream(destPath);
			ByteBuffer bbr = ByteBuffer.allocate(1024);
			FileChannel readChannel = fis.getChannel();
			FileChannel writeChannel = fos.getChannel();
			while (true) {
				int len = readChannel.read(bbr);
				System.out.println(len);
				if (len <= 0) {
					break;
				}
				bbr.flip();
				writeChannel.write(bbr);
			}
			readChannel.close();
			writeChannel.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
