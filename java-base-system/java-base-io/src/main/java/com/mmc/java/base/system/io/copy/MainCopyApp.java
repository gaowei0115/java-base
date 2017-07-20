// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.copy;

import java.io.File;
import java.io.IOException;

/** 
 * className: MainCopyApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MainCopyApp {

	public static void main(String[] args) throws IOException {
		System.out.println(MainCopyApp.class.getResource(""));
		System.out.println(MainCopyApp.class.getResource("/"));
		File file = new File("");
		String canonicalPath = file.getCanonicalPath();
		System.out.println(canonicalPath);
		System.out.println(file.getAbsolutePath());
		String path = MainCopyApp.class.getResource("").getPath();
		String srcPath = path + "src.txt";
		String destPath = path + "dest.txt";
		NioFileCopy.fileCopy(srcPath, destPath);
	}
}
