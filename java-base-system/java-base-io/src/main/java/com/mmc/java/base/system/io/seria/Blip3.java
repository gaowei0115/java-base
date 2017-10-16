// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/** 
 * ClassName: Blip3<br/>
 * Description: 对象序列化完整保存恢复实现<br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Blip3 implements Externalizable {

	private String s;
	private int i;
	
	public Blip3(){}
	
	public Blip3(int iinit, String sinit) {
		this.i = iinit;
		this.s = sinit;
	}
	
	
	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Blip3: [i= + " + i + ", s= " + s + "]";
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(s);
		out.writeInt(i);
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.s = (String) in.readObject();
		this.i = in.readInt();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = "E:\\bak\\file\\Blip3.out";
		Blip3 blip3 = new Blip3(1, "blip3");
		System.out.println("before " + blip3);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		System.out.println("saving object ");
		oos.writeObject(blip3);
		oos.close();
		
		System.out.println("recoving object ");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		blip3 = (Blip3) ois.readObject();
		System.out.println("after " + blip3);
		ois.close();
	}

}
