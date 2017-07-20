// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future;

/** 
 * className: Client<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class Client {

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param param
	 * @return
	 */
	public Data request(final String param) {
		final FutureData futureData = new FutureData();
		new Thread() {
			
			public void run() {
				RealData realData = new RealData(param);
				futureData.setRealData(realData);
			}
		}.start();
		return futureData;
	}
}
