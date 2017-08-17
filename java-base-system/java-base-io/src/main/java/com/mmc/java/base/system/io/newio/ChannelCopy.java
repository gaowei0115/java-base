package com.mmc.java.base.system.io.newio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 包 名：com.mmc.java.base.system.io.newio
 * 类 名: ChannelCopy
 * 描 述: 通过Channel实现文件拷贝
 * 作 者: GW
 * 创 建： 2017-08-17 17:12
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class ChannelCopy {

    private static final int SIZE = 1024;

    public static void main(String[] args) throws Exception {
        System.out.println(new ChannelCopy().getClass().getResource("").getPath());
        String path = new ChannelCopy().getClass().getResource("").getPath() + "1.txt";
        String pathcopy = new ChannelCopy().getClass().getResource("").getPath() + "1copy.txt";
        FileInputStream fis = new FileInputStream(path);
        FileChannel in = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(pathcopy);
        FileChannel out = fos.getChannel();

        ByteBuffer buff = ByteBuffer.allocate(SIZE);
        while ((in.read(buff)) != -1) {
            buff.flip();
            out.write(buff);
            buff.clear();
        }
        out.close();
        in.close();
        fis.close();
        fos.close();
    }
}
