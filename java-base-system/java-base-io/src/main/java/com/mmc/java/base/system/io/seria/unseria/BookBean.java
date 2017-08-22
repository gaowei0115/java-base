// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria.unseria;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import static java.lang.System.out;

/** 
 * ClassName: BookBean<br/>
 * Description: 使用实现Externalizable接口实现对实体bean中某个属性不序列化<br/>
 * Author: GW<br/>
 * Create： 2017年8月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class BookBean implements Externalizable{

	// 指定guidePrice（指导价位不进行序列化）
	
	private long bookId;
	private String bookName;
	private String publish;
	private double bookPrice;
	private double guidePrice;
	
	/**
	 * @return the bookId
	 */
	public long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the publish
	 */
	public String getPublish() {
		return publish;
	}

	/**
	 * @param publish the publish to set
	 */
	public void setPublish(String publish) {
		this.publish = publish;
	}

	/**
	 * @return the bookPrice
	 */
	public double getBookPrice() {
		return bookPrice;
	}

	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	/**
	 * @return the guidePrice
	 */
	public double getGuidePrice() {
		return guidePrice;
	}

	/**
	 * @param guidePrice the guidePrice to set
	 */
	public void setGuidePrice(double guidePrice) {
		this.guidePrice = guidePrice;
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(bookId);
		out.writeObject(bookName);
		out.writeObject(publish);
		out.writeDouble(bookPrice);
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.bookId = in.readLong();
		this.bookName = (String)in.readObject();
		this.publish = (String)in.readObject();
		this.bookPrice = in.readDouble();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book : [bookId:" + bookId + ", bookName:" + bookName + ", publish:" + publish + ", bookPrice:" + bookPrice + ", guidePrice:" + guidePrice + "]";
	}
	
	/**
	 * Description：测试入口<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BookBean.out"));
			BookBean book = new BookBean();
			book.setBookId(10000L);
			book.setBookName("thank in java");
			book.setPublish("usa");
			book.setBookPrice(100.0);
			book.setGuidePrice(100.0);
			out.println(" object serialiable before " + book.toString());
			out.println(" save serialiable .....");
			oos.writeObject(book);
			
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BookBean.out"));
			out.println(" read serialiable ......");
			Object obj = ois.readObject();
			out.println(" object serialiable after " + obj.toString());
			ois.close();
		} catch (IOException e) {
			
		} catch (Exception e) {
			
		}
		
	}

}
