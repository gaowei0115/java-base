// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/** 
 * className: MappedByteBufferTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MappedByteBufferTest {

	public static void main(String[] args) {
		try {
			RandomAccessFile accessFile = new RandomAccessFile(MappedByteBufferTest.class.getResource("").getPath() + "src.txt", "rw");
			FileChannel fc = accessFile.getChannel();
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, accessFile.length());
			while (mbb.hasRemaining()) {
				System.out.print(mbb.get());
			}
			mbb.put(0, (byte)98);
			accessFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
