// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future;

/** 
 * className: MainApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MainApp {

	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕！");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		
		System.out.println("数据=" + data.getResult());
	}
}
