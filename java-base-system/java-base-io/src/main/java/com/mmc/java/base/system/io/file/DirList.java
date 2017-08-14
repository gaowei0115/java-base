// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/** 
 * className: DirList<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class DirList {

	
	public static void main(String[] args) {
		File file = new File(".");
		String[] list;
		if (args.length == 0) {
			list = file.list();
		} else {
			list = file.list(new DirFilter(args[0]));
		}
		
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String f : list) {
			System.out.println(f);
		}
	}
	
	/**
	 * className: DirFilter<br/>
	 * Description: 文件名称过滤器<br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月14日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	static class DirFilter implements FilenameFilter {
		
		private Pattern pattern;
		
		public DirFilter(String regex) {
			this.pattern = Pattern.compile(regex);
		}

		/* (non-Javadoc)
		 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
		 */
		public boolean accept(File dir, String name) {
			return pattern.matcher(name).matches();
		}
		
	}
}
