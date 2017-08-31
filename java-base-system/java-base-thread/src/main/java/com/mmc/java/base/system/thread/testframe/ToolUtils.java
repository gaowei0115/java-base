// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.testframe;

/** 
 * className: ToolUtils<br/>
 * Description: 模拟工具类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月30日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ToolUtils {

	/**
	 * Description：产生随机数<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param y
	 * @return
	 */
	public static int random(int y) {
		y ^= (y << 6);
		y ^= (y >>> 21);
		y ^= (y << 7);
		return y;
	}
	
	public static void main(String[] args) {
		System.out.println(random(10));
	}
}
