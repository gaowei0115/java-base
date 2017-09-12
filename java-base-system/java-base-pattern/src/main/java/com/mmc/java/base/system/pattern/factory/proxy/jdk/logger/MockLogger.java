// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * className: MockLogger<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MockLogger implements Logger {

	private final Class<?> clazz;
	
	public MockLogger(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.Logger#debug(java.lang.String)
	 */
	@PointC
	public void debug(String message) {
		System.out.println(getPrefix("DEBUG") + message);
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.Logger#info(java.lang.String)
	 */
	public void info(String message) {
		System.out.println(getPrefix("INFO") + message);
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.Logger#error(java.lang.String)
	 */
	public void error(String message) {
		System.err.println(getPrefix("ERROR") + message);
	}
	
	public String getPrefix(String level) {
		StringBuffer sb = new StringBuffer();
		sb.append("[java-base-pattern] - ");
		sb.append("[" + level + "] ");
		sb.append("" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " - ");
		sb.append(clazz.getName() + " - ");
		return sb.toString();
	}

}
