// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension;

import java.io.Serializable;

/** 
 * ClassName: Reqest<br/>
 * Description: 模拟请求对象<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4259109714850678657L;
	
	
	// 请求消息
	private String requestParam;
	
	/**
	 * @param param
	 */
	public Request(String param) {
		this.requestParam = param;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public String getRequestParam() {
		return this.requestParam;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[request " + this.requestParam + "]";
	}
	
}
