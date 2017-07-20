// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future;

/** 
 * className: RealData<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class RealData implements Data {

	protected final String result;
	
	public RealData(String param) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(param);
		}
		result = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.thread.future.Data#getResult()
	 */
	public String getResult() {
		return result;
	}

}
