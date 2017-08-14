// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/** 
 * className: DirListIner<br/>
 * Description: 匿名内存类实现文件过滤<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DirListIner {
	
	public static void main(String[] args) {
		File file = new File(".");
		String[] list;
		if (args.length == 0) {
			list = file.list();
		} else {
			list = file.list(filter(args[0]));
		}
		
		Arrays.sort(list);
		for (String f : list) {
			System.out.println(f);
		}
	}

	/**
	 * Description：匿名内部类实现文件名过滤器<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param regex
	 * @return
	 */
	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}
}
