// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent;

/** 
 * className: GumballMonitor<br/>
 * Description: 代理监视器<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class GumballMonitor {

	private GumballMachine gumballMachine;
	
	/**
	 * @param gumballMachine
	 */
	public GumballMonitor(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public void report() {
		System.out.println("gumball Machine location: " + gumballMachine.getLocation());
		System.out.println("Current inventory: " + gumballMachine.getCount() + " gumballs");
		System.out.println("Current state: " + gumballMachine.getState());
	}
}
