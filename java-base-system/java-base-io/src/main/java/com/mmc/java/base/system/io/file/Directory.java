// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/** 
 * ClassName: Directory<br/>
 * Description: 实现文件集操作<br/>
 * Author: GW<br/>
 * Create： 2017年8月14日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public final class Directory {

	/**
	 * Description：加载本地文件集<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param dir
	 * @param regex
	 * @return
	 */
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
	} 
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param path
	 * @param regex
	 * @return
	 */
	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param startDir
	 * @param regex
	 * @return
	 */
	public static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo info = new TreeInfo();
		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				info.dirList.add(item);
				info.addAll(recurseDirs(item, regex));
			} else {
				if (item.getName().matches(regex)) {
					info.fileList.add(item);
				}
			}
		}
		return info;
	}
	
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param start
	 * @param regex
	 * @return
	 */
	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}
	
	public static TreeInfo walk(File file, String regex) {
		return recurseDirs(file, regex);
	}
	
	public static TreeInfo walk(String path) {
		return recurseDirs(new File(path), ".*");
	}
	
	/**
	 * ClassName: TreeInfo<br/>
	 * Description: 文件数型遍历对象<br/>
	 * Author: GW<br/>
	 * Create： 2017年8月14日<br/>
	 *
	 * History: (Version) Author dateTime description <br/>
	 */
	static class TreeInfo implements Iterable<File> {

		public List<File> dirList = new ArrayList<File>();
		public List<File> fileList = new ArrayList<File>();
		
		/**
		 * Description：<br/>
		 * Author：GW<br/>
		 * History: (Version) Author dateTime description <br/>
		 * @return
		 */
		public Iterator<File> iterator() {
			return fileList.iterator();
		}
		
		/**
		 * Description：<br/>
		 * Author：GW<br/>
		 * History: (Version) Author dateTime description <br/>
		 * @param treeInfo
		 */
		public void addAll(TreeInfo treeInfo) {
			dirList.addAll(treeInfo.dirList);
			fileList.addAll(treeInfo.fileList);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "dirs : " + PPrint.pformat(dirList) + "\n\n" + "files : " + PPrint.pformat(fileList);
		}
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(walk("."));
		} else {
			for (String arg : args) {
				System.out.println(walk(arg));
			}
		}
	}
	
}
