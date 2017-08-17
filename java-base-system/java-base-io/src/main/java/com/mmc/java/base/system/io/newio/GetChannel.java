package com.mmc.java.base.system.io.newio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 包 名：com.mmc.java.base.system.io.newio
 * 类 名: GetChannel
 * 描 述: 简单获取通道测试
 * 作 者: GW
 * 创 建： 2017-08-17 16:35
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class GetChannel {

    private static final int SIZE = 1024;

    public static void main(String[] args)  throws Exception{

        // 获取通道
        FileChannel fc = new FileOutputStream("rtest.txt").getChannel();

        fc.write(ByteBuffer.wrap("file output channle test".getBytes()));
        fc.close();

        fc = new RandomAccessFile("rtest.txt", "rw").getChannel();
        fc.position(fc.size());// 定位文件当前位置
        fc.write(ByteBuffer.wrap("file random access file".getBytes()));
        fc.close();

        fc = new FileInputStream("rtest.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(SIZE);
        fc.read(buff);
        buff.flip();

        while (buff.hasRemaining()) {
            System.out.println((char) buff.get());
        }

    }
}


