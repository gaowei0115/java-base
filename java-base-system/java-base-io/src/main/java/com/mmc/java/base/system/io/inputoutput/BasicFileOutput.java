// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/** 
 * className: BasicFileOutput<br/>
 * Description: 文件输出<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class BasicFileOutput {

	/**
	 * Description：读入文件，添加行号写回源文件<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String path = new BasicFileOutput().getClass().getResource("").getPath() + "test.txt";
		BufferedReader br = new BufferedReader(new StringReader(BufferedReaderFile.read(path)));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)));
		int countline = 1;
		String s ;
		while ((s = br.readLine()) != null) {
			s = countline++ + " : " + s;
			pw.println(s);
		}
		pw.close();
		br.close();
		System.out.println(BufferedReaderFile.read(path));
	}
}
