// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.logger;

/** 
 * className: Logger<br/>
 * Description: 模拟日志接口<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public interface Logger {

	void debug(String message);
	
	void info(String message);
	
	void error(String message);
}
