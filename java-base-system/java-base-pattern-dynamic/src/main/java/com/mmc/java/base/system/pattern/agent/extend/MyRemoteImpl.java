// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent.extend;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/** 
 * className: MyRemoteImpl<br/>
 * Description: 远程接口实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws RemoteException
	 */
	protected MyRemoteImpl() throws RemoteException {
	}

	/* (non-Javadoc)
	 * @see com.mmc.java.base.system.pattern.agent.extend.MyRemote#sayHello()
	 */
	public String sayHello() throws RemoteException {
		return "Server say hello";
	}
	
	public static void main(String[] args) {
		System.setProperty("java.rmi.server.hostname","127.0.0.1");
		try {
			LocateRegistry.createRegistry(8080);
			MyRemote remote = new MyRemoteImpl();
			Naming.rebind("rmi://10.0.20.78:8080/RemoteHello", remote);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
