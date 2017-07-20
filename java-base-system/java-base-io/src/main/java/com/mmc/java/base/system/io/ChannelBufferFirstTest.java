// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** 
 * className: ChannelBufferFirstTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ChannelBufferFirstTest {

	public static void main(String[] args) throws Exception {
		String file = "";
		FileInputStream fis = new FileInputStream(file);
		FileChannel fc = fis.getChannel();
		ByteBuffer bbr = ByteBuffer.allocate(1024);
		fc.read(bbr);
		
		fc.close();
		fis.close();
		bbr.flip();
	}
}
