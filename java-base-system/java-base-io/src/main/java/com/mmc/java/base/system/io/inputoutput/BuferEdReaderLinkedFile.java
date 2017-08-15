// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.io.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/** 
 * className: BuferEdReaderLinkedFile<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class BuferEdReaderLinkedFile {

	public static LinkedList<String> readLinkedList(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String temp;
		LinkedList<String> resultList = new LinkedList<String>();
		while ((temp = br.readLine()) != null) {
			resultList.add(temp);
		}
		br.close();
		return resultList;
	}
	
	public static LinkedList<String> readLinkedListOfWord(String filename, String regex) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String temp;
		LinkedList<String> result = new LinkedList<String>();
		while ((temp = br.readLine()) != null) {
			if (temp.indexOf(regex) != -1) {
				result.add(temp);
			}
		}
		br.close();
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		String path ;
		if (args.length == 0) {
			path = new BuferEdReaderLinkedFile().getClass().getResource("").getPath() + "link.txt";
		} else {
			System.out.println("args .." + args[0]);
			path = new BuferEdReaderLinkedFile().getClass().getResource("").getPath() + args[0];
		}
		String regex = "";
		if (args[1] != null) {
			regex = args[1];
		}
//		LinkedList<String> result = readLinkedList(path);
		LinkedList<String> result = readLinkedListOfWord(path, regex);
		System.out.println("before -- after [");
		for (String r : result) {
			System.out.println(r);
		}
		System.out.println("]");
		
		System.out.println("after -- before [");
		int n = result.size();
		for (int i = 0; i < n; i++) {
			System.out.println(result.pollLast());
		}
		System.out.println("]");
	}
}
