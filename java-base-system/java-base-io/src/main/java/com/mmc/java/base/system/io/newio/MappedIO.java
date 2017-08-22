// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.newio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * ClassName: MappedIO<br/>
 * Description: IO性能比较<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class MappedIO {

	private static int numOfInts = 4000000;
	private static int numOfbuffInts = 200000;

	/**
	 * ClassName: Tester<br/>
	 * Description: 测试框架基类<br/>
	 * Author: GW<br/>
	 * Create： 2017年8月19日<br/>
	 *
	 * History: (Version) Author dateTime description <br/>
	 */
	private abstract static class Tester {

		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTest() {
			System.out.print(name + " : ");
			try {
				long start = System.nanoTime();
				test();
				long end = System.nanoTime();
				System.out.println(String.format(" cost time : %s s", (end - start) / 1.0e6));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public abstract void test() throws IOException;
	}

	private static Tester[] tests = { new Tester("Stream Writer..") {

		@Override
		public void test() throws IOException {
			String path = "E:\\bak\\file\\stream.txt";
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
			for (int i = 0; i < numOfInts; i++) {
				dos.writeInt(i);
			}
			dos.close();
		}
	},

			new Tester("Mapped Writer") {
				String path = "E:\\bak\\file\\mapped.txt";
				String path1 = "E:\\bak\\file\\stream.txt";

				@Override
				public void test() throws IOException {
					FileChannel fc1 = new RandomAccessFile(path1, "rw").getChannel();
					RandomAccessFile raf = new RandomAccessFile(path, "rw");
					FileChannel fc = raf.getChannel();
					// 由MappedBuffer转成IntBuffer视图
					IntBuffer ib = fc.map(MapMode.READ_WRITE, 0, fc1.size()).asIntBuffer();
					for (int i = 0; i < numOfInts; i++) {
						ib.put(i);
					}
					fc.close();
					raf.close();
				}
			},

			new Tester("Stream reader ") {
				String path = "E:\\bak\\file\\stream.txt";

				@Override
				public void test() throws IOException {
					DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
					for (int i = 0; i < numOfInts; i++) {
						dis.readInt();
					}
					dis.close();
				}
			},

			new Tester("Mapped reader ") {
				String path = "E:\\bak\\file\\mapped.txt";
				String path1 = "E:\\bak\\file\\stream.txt";

				@Override
				public void test() throws IOException {
					FileChannel fc1 = new RandomAccessFile(path1, "rw").getChannel();
					RandomAccessFile raf = new RandomAccessFile(path, "r");
					FileChannel fc = raf.getChannel();
					MappedByteBuffer mbb = fc.map(MapMode.READ_ONLY, 0, fc1.size());
					IntBuffer ib = mbb.asIntBuffer();
					for (int i = 0; i < numOfInts; i++) {
						ib.get();
					}
					ib.clear();
					mbb.clear();
					fc.close();
					raf.close();
				}

			},

			new Tester("Stream reader/writer ") {
				String path = "E:\\bak\\file\\stream.txt";

				@Override
				public void test() throws IOException {
					RandomAccessFile raf = new RandomAccessFile(path, "rw");
					raf.writeInt(1);
					for (int i = 0; i < numOfbuffInts; i++) {
						raf.seek(raf.length() - 4);
						raf.writeInt(raf.readInt());
					}
					raf.close();
				}
			},

			new Tester("Mapped reader/writer ") {
				String path = "E:\\bak\\file\\mapped.txt";
				String path1 = "E:\\bak\\file\\stream.txt";

				@Override
				public void test() throws IOException {
					FileChannel fc1 = new RandomAccessFile(path1, "rw").getChannel();
					RandomAccessFile raf = new RandomAccessFile(path, "rw");
					FileChannel fc = raf.getChannel();
					MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, fc1.size());
					IntBuffer ib = mbb.asIntBuffer();
					ib.put(0);
					for (int i = 1; i < numOfbuffInts; i++) {
						ib.put(ib.get(i - 1));
					}
					fc.close();
					raf.close();
				}
			} };

	public static void main(String[] args) {
		for (Tester t : tests) {
			t.runTest();
			System.out.println();
		}
	}
}
