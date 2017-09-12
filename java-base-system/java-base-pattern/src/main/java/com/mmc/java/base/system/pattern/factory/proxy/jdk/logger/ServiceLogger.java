// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.logger;

/** 
 * className: ServiceLogger<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ServiceLogger{
	
	private final Logger logger;

	public ServiceLogger(Logger logger) {
		this.logger = logger;
	}
	
	@PointC
	public void aroundLogger() {
		logger.debug("");
	}
}
