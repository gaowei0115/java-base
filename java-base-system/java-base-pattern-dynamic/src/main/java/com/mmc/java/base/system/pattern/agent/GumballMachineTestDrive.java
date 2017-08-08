// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent;

/** 
 * className: GumballMachineTestDrive<br/>
 * Description: 测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class GumballMachineTestDrive {

	public static void main(String[] args) {
		int count = 0;
		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		count = Integer.parseInt(args[1]);
		GumballMachine gumballMachine = new GumballMachine(args[0], count);
		GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
		gumballMonitor.report();
	}
}
