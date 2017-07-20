// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.producercustomer;

/** 
 * ClassName: PcData<br/>
 * Description: 模拟生产者消费者交互数据对象，使用final类型<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public final class PcData {

	private int iData;
	
	/**
	 * @param iData
	 */
	public PcData(int iData) {
		this.iData = iData;
	}
	
	/**
	 * @param iData
	 */
	public PcData(String iData) {
		this.iData = Integer.parseInt(iData);
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public int getIData() {
		return this.iData;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[data:" + this.iData + "]";
	}
}
