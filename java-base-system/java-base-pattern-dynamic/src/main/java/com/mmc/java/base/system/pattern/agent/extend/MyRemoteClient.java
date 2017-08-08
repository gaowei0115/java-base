// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent.extend;

import java.rmi.Naming;

/** 
 * className: MyRemoteClient<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MyRemoteClient {

	public static void main(String[] args) {
		new MyRemoteClient().go();
	}
	
	public void go() {
		try {
			MyRemote myRemote = (MyRemote) Naming.lookup("rmi://10.0.20.78:8080/RemoteHello");
			String s = myRemote.sayHello();
			System.out.println(s);
		} catch (Exception e) {
			
		}
	}
}
