// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent;

/** 
 * className: GumballMachine<br/>
 * Description: 代理目标类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class GumballMachine {

	private String location;
	private Integer count;
	
	/**
	 * @param location
	 * @param count
	 */
	public GumballMachine(String location, Integer count) {
		this.location = location;
		this.count = count;
	}
	
	public String getState() {
		return "1";
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
