// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.base.system.jvm.reflect.impl;

import java.io.Serializable;

import com.mmc.base.system.jvm.reflect.ReflectService;

/**
 * ClassName: ReflectServiceImpl<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月17日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ReflectServiceImpl implements ReflectService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String password;
	private Object obj;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mmc.base.system.jvm.reflect.ReflectService#add()
	 */
	public void add() {
		System.out.println("add .........");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mmc.base.system.jvm.reflect.ReflectService#delete()
	 */
	public void delete() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mmc.base.system.jvm.reflect.ReflectService#update()
	 */
	public void update() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mmc.base.system.jvm.reflect.ReflectService#query()
	 */
	public void query() {

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
