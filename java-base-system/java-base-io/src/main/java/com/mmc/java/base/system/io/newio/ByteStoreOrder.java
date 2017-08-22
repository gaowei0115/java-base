// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/** 
 * ClassName: ByteStoreOrder<br/>
 * Description: 字节码存储顺序问题，默认高位存储-低位存储<br/>
 * Author: GW<br/>
 * Create： 2017年8月18日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ByteStoreOrder {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 'a'});
		
		// 默认高位排序
		// 转换成intbuffer输出
		IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
		while (ib.hasRemaining()) {
			System.out.println(ib.get());
		}
		
		// 设置字节排序模式
		bb.order(ByteOrder.LITTLE_ENDIAN);
		ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
		while (ib.hasRemaining()) {
			System.out.println(ib.get());
		}
	}
}
