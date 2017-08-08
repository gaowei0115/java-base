// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.reflect;

/** 
 * className: ReflectClass<br/>
 * Description: 反射目标实现类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ReflectClass {

	private String desc;
	
	private Integer count;
	
	/**
	 * @param desc
	 * @param count
	 */
	public ReflectClass(String desc, Integer count) {
		this.desc = desc;
		this.count = count;
	}
	
	public void getInfo() {
		System.out.println("get info.... " + desc + ", count" + count);
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
