// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent.extend;

import java.rmi.Remote;
import java.rmi.RemoteException;

/** 
 * className: MyRemote<br/>
 * Description: 自定义远程访问接口<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public interface MyRemote extends Remote {

	/**
	 * Description：提供远程方法<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 * @throws RemoteException
	 */
	public String sayHello() throws RemoteException;
}
