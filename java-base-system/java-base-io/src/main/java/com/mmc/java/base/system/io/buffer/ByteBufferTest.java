// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.buffer;

import java.nio.ByteBuffer;

/** 
 * className: ByteBufferTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ByteBufferTest {

	public static void main(String[] args) {
		ByteBuffer bbr = ByteBuffer.allocate(15);
		System.out.println(String.format("position: %s, limit: %s, capacity: %s", bbr.position(), bbr.limit(), bbr.capacity()));
		
		// 写入十个byte
		for (int i = 0; i < 10; i++) {
			bbr.put((byte)i);
		}
		System.out.println(String.format("position: %s, limit: %s, capacity: %s", bbr.position(), bbr.limit(), bbr.capacity()));
		// 重置缓冲区上线
		bbr.flip();
		System.out.println(String.format("position: %s, limit: %s, capacity: %s", bbr.position(), bbr.limit(), bbr.capacity()));
		
		// 读取缓冲区5个byte
		for (int i = 0; i < 5; i++) {
			System.out.println(bbr.get());
		}
		System.out.println(String.format("position: %s, limit: %s, capacity: %s", bbr.position(), bbr.limit(), bbr.capacity()));
		// 重置缓冲区上线
		bbr.flip();
		System.out.println(String.format("position: %s, limit: %s, capacity: %s", bbr.position(), bbr.limit(), bbr.capacity()));
	}
}
