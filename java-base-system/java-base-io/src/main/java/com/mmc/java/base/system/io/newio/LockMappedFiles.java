// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;

/** 
 * ClassName: LockMappedFiles<br/>
 * Description: 对文件映射加锁<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class LockMappedFiles {

	private static final int SIZE = 20000;//0x8FFFFFF;
	
	private static FileChannel fc;
	
	public static void main(String[] args) throws IOException {
		String file = "E:\\bak\\file\\mapped.txt";
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		fc = raf.getChannel();
		MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, SIZE);
		for (int i = 0; i < SIZE; i++) {
			mbb.put((byte)'X');
		}
		
		new LockAndModify(mbb, 0, SIZE / 3);
		new LockAndModify(mbb, SIZE / 2, SIZE / 2 + SIZE / 4);
		
//		raf.close();
		
	}
	
	private static class LockAndModify extends Thread {
		
		private final ByteBuffer buff;
		private final int start;
		private final int end;
		
		public LockAndModify(ByteBuffer initBuff, int initStart, int initEnd) {
			this.start = initStart;
			this.end = initEnd;
			initBuff.limit(end);
			initBuff.position(start);
			buff = initBuff.slice();
			start();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				FileLock fl = fc.lock(start, end, false);
				System.out.println("Locked : " + start + " to " + end);
				while (buff.position() < buff.limit() - 1) {
					buff.put((byte)(buff.get() + 1));
				}
				fl.release();
				System.out.println("released " + start + " to " + end);
			} catch (IOException e) {
				
			}
		}
	}
}
