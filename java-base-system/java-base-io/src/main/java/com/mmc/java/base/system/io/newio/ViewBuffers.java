// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/** 
 * ClassName: ViewBuffers<br/>
 * Description: ByteBuffer 转换成不同基本类型Buffer视图<br/>
 * Author: GW<br/>
 * Create： 2017年8月18日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ViewBuffers {

	private static final int SIZE = 1024;
	
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(SIZE);
		byte[] data = new byte[] {0, 0, 0, 0, 0, 'a'};
		bb = ByteBuffer.wrap(data);
		bb.rewind();
		System.out.println("Byte Buffer ");
		while (bb.hasRemaining()) {
			System.out.println(bb.position() + " -> " + bb.get());
		}
		
		CharBuffer charBuffer = ((ByteBuffer)bb.rewind()).asCharBuffer();
		System.out.println("Char Buffer ");
		while (charBuffer.hasRemaining()) {
			System.out.println(charBuffer.position() + " -> " + charBuffer.get());
		}
		
		ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
		System.out.println("short buffer ");
		while (sb.hasRemaining()) {
			System.out.println(sb.position() + " -> " + sb.get());
		}
		
		IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
		System.out.println("int buffer ");
		while (ib.hasRemaining()) {
			System.out.println(ib.position() + " -> " + ib.get());
		}
		
		FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
		System.out.println("float buffer ");
		while (fb.hasRemaining()) {
			System.out.println(fb.position() + " -> " + fb.get());
		}
		
		LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
		System.out.println("long buffer ");
		while (lb.hasRemaining()) {
			System.out.println(lb.position() + " -> " + lb.get());
		}
		
		DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
		System.out.println("double buffer ");
		while (db.hasRemaining()) {
			System.out.println(db.position() + " -> " + db.get());
		}
	}
}
