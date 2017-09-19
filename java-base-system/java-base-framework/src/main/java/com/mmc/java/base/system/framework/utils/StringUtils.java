// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.framework.utils;

/** 
 * className: StringUtils<br/>
 * Description: 字符串工具类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class StringUtils {

	/**
	 * Description：验证字符串为空<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty(String arg) {
		if (arg == null || arg.length() == 0) {
			return true;
		}
		return false;
	} 
	
	/**
	 * Description：验证字符串非空<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param arg
	 * @return
	 */
	public static boolean isNotEmpty(String arg) {
		return !(isEmpty(arg));
	}
}
