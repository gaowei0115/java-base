// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension.result;

import com.mmc.java.base.system.thread.future.Data;

/** 
 * ClassName: ResultRequest<br/>
 * Description: 带有返回结果的请求对象，通过future模式实现返回结果<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ResultRequest {

	private String param;
	
	private Data response;
	
	/**
	 * @param param
	 */
	public ResultRequest(String param) {
		this.param = param;
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param res
	 */
	public synchronized void setResponse(Data res) {
		this.response = res;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public synchronized Data getResponse() {
		return this.response;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public String getParam() {
		return this.param;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[request " + this.param + "]";
	}
}
