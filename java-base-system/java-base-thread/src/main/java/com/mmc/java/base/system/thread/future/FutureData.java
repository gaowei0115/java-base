// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future;

/** 
 * className: FutureData<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class FutureData implements Data{
	
	protected RealData realData = null;
	
	protected boolean isReady = false;

	
	public synchronized void setRealData(RealData realData) {
		if (isReady) {
			return ;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();
	}
	
	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.thread.future.Data#getResult()
	 */
	public synchronized String getResult() {
		while (!isReady) {
			try {
				wait();
			} catch (Exception e) {
				
			}
		}
		return realData.result;
	}

}
