// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.guardedsuspension;

/** 
 * ClassName: GuardedSuspensionMain<br/>
 * Description: 模拟请求<br/>
 * Author: GW<br/>
 * Create： 2017年7月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class GuardedSuspensionMain {

	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		for (int i = 0; i < 10; i++) {// 模拟开启十个服务端处理线程
			new ServerThread(requestQueue, "ServerThread" + i).start();
		}
		
		for (int i = 0; i < 10; i++) {// 模拟开启十个客户端处理线程
			new ClientThread(requestQueue, "ClientThread" + i).start();
		}
	}
}
