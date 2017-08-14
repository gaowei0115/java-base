// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/** 
 * className: SortDirList<br/>
 * Description: 根据路径获取文件列表<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SortDirList {
	
	private final String path;
	
	public SortDirList(String path) {
		this.path = path;
	}

	public String[] list() {
		File file = new File(path);
		String[] result = file.list();
		Arrays.sort(result);
		return result;
	}
	
	public String[] list(String regex) {
		File file = new File(path);
		String[] result = file.list(filter(regex));
		Arrays.sort(result);
		return result;
	}
	
	public static void main(String[] args) {
		String path = "D:\\gw\\mmc\\";
		SortDirList sortDirList = new SortDirList(path);
		String[] result = sortDirList.list();
		System.out.println("no regex ......");
		for (String f : result) {
			System.out.println(f);
		}
		System.out.println(" regex .......");
		result = sortDirList.list("(p?)");
		
		for (String f : result) {
			System.out.println(f);
		}
	}
	
	
	/**
	 * Description：<br/>
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
