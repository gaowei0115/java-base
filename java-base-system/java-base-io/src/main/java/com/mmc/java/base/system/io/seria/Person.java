// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria;

import java.io.Serializable;

/** 
 * ClassName: Person<br/>
 * Description: 序列化对象<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String address;
	
	private transient String password;

	
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "person : [ name:" + name + ", address: " + address + ", password: " + password + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.address.hashCode() >> 2 + (this.name.hashCode() >> 4);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Person) {
			Person temp = (Person) obj;
			if (!this.name.equals(temp.getName())) {
				return false;
			}
			if (!this.address.equals(temp.getAddress())) {
				return false;
			}
		}
		return false;
	}
}
