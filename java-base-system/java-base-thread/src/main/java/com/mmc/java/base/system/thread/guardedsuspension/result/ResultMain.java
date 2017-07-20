// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension.result;

/** 
 * ClassName: ResultMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ResultMain {

	public static void main(String[] args) {
		ResultRequestQueue requestQueue = new ResultRequestQueue();
		for (int i = 0; i < 10; i++) {// 模拟开启十个服务端处理线程
			new ResultServerThread(requestQueue, "ResultServerThread" + i).start();
		}
		
		for (int i = 0; i < 10; i++) {// 模拟开启十个客户端处理线程
			new ResultClientThread(requestQueue, "ResultClientThread" + i).start();
		}
	}
}
