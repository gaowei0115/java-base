package com.mmc.java.base.system.io.newio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 包 名：com.mmc.java.base.system.io.newio
 * 类 名: TransferTo
 * 描 述: 模拟实现文件传输
 * 作 者: GW
 * 创 建： 2017-08-17 17:48
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TransferTo {

	public static void main(String[] args) throws Exception {
        String path = new ChannelCopy().getClass().getResource("").getPath() + "1.txt";
        String pathcopy = new ChannelCopy().getClass().getResource("").getPath() + "1copy.txt";
        FileInputStream fis = new FileInputStream(path);
        FileChannel in = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(pathcopy);
        FileChannel out = fos.getChannel();
        int position = 0;
        in.transferTo(position, in.size(), out);
        
        out.close();
        in.close();
        fos.close();
        fis.close();
    }
}
