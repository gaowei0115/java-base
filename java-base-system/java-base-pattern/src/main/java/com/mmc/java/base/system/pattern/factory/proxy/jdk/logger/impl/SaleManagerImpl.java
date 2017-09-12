// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.impl;

import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.Logger;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.LoggerHandler;
import com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.SaleManager;

/** 
 * className: SaleManagerImpl<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月12日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SaleManagerImpl implements SaleManager {

	private Logger logger = LoggerHandler.logger;
	
	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.SaleManager#addSale()
	 */
	public void addSale() {
		logger.debug("add sale....");
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.factory.proxy.jdk.logger.SaleManager#delSale()
	 */
	public void delSale() {
		logger.info("del sale....");
	}

}
