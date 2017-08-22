// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria.last;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import static java.lang.System.out;

/** 
 * ClassName: LastSerialiable<br/>
 * Description: 对象持久性测试，当存在两个对象同时指向同一个对象引用时，序列化测试<br/>
 * Author: GW<br/>
 * Create： 2017年8月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class LastSerialiable {

	
	static class House implements Serializable {
		
	}
	
	static class Animal implements Serializable {
		private String name;
		private House house;
		
		Animal(String nameinit, House houseinit) {
			this.name = nameinit;
			this.house = houseinit;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return name + "[ " + super.toString() + "]. " + house + "\n";
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		House house = new House();
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Bosoc the dog", house));
		animals.add(new Animal("Ralph the hamster", house));
		out.println(animals);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(animals);
		oos.writeObject(animals);
		
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		ObjectOutputStream oos1 = new ObjectOutputStream(baos1);
		oos1.writeObject(animals);
		
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		List<Animal> animals1 = (List<Animal>) ois.readObject();
		List<Animal> animals2 = (List<Animal>) ois.readObject();
		
		ObjectInputStream ois1 = new ObjectInputStream(new ByteArrayInputStream(baos1.toByteArray()));
		List<Animal> animals3 = (List<Animal>) ois1.readObject();
		
		out.println(animals1);
		out.println(animals2);
		out.println(animals3);
	}
}
