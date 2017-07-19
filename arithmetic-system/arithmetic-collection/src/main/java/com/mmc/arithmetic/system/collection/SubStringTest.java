// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.collection;

import java.util.ArrayList;
import java.util.List;

/** 
 * className: SubStringTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月18日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SubStringTest {
	
	
	
	public static void main(String[] args) {
		List<String> handle = new ArrayList<String>();
		
		HugeStr hugeStr = new HugeStr();
		ImproveHugeStr improveHugeStr = new ImproveHugeStr();
		for (int i = 0; i < 1000; i++) {
			handle.add(hugeStr.getString(1, 5));
			handle.add(improveHugeStr.getString(1, 5));
		}
	}

	static class HugeStr {
		private String str = new String(new char[100000]);
		
		public String getString(int begin, int end) {
			return str.substring(begin, end);
		}
	}
	
	static class ImproveHugeStr {
		private String str = new String(new char[100000]);
		
		public String getString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}
}
