// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.file;

import java.io.File;

/** 
 * className: KnowFile<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class KnowFile {

	public static void main(String[] args) {
		System.out.println(KnowFile.class.getClassLoader().getResource("").getPath());
		File file = new File("KnowFile.java");
		System.out.println(file.exists());
	}
}
