// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/** 
 * ClassName: FileLocking<br/>
 * Description: 文件加锁<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class FileLocking {

	public static void main(String[] args) throws IOException, InterruptedException {
		String file = "E:\\bak\\file\\file.txt";
		FileOutputStream fos = new FileOutputStream(file);
		FileLock fl = fos.getChannel().tryLock();
		if (fl != null) {
			System.out.println(" locked file ");
			TimeUnit.SECONDS.sleep(10);
			fl.release();
			System.out.println(" release lock");
		}
		fos.close();
	}
}
