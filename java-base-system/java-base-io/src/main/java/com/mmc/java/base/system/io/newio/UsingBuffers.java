// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/** 
 * ClassName: UsingBuffers<br/>
 * Description: 交换相邻字符<br/>
 * Author: GW<br/>
 * Create： 2017年8月18日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class UsingBuffers {

	public static void symmetricScramble(CharBuffer charBuffer) {
		while (charBuffer.hasRemaining()) {
			charBuffer.mark();
			char c1 = charBuffer.get();
			char c2 = charBuffer.get();
			charBuffer.reset();
			charBuffer.put(c2).put(c1);
		}
	}
	
	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		System.out.println();
	}
}
