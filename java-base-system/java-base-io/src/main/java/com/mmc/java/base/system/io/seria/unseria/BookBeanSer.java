// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria.unseria;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ClassName: BookBeanSer<br/>
 * Description: 通过实现Serializable接口实现序列化，通过transient实现过滤某个字段不进行实例化<br/>
 * Author: GW<br/>
 * Create： 2017年8月20日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class BookBeanSer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -556489875960605933L;

	// 指定guidePrice（指导价位不进行序列化）

	private long bookId;
	private String bookName;
	private String publish;
	private double bookPrice;
	private transient double guidePrice;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book : [bookId:" + bookId + ", bookName:" + bookName + ", publish:" + publish + ", bookPrice:" + bookPrice + ", guidePrice:" + guidePrice + "]";
	}
	
	public static void main(String[] args) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BookBeanSer.out"));
			BookBeanSer book = new BookBeanSer();
			book.setBookId(10000L);
			book.setBookName("thank in java");
			book.setPublish("usa");
			book.setBookPrice(100.0);
			book.setGuidePrice(100.0);
			out.println(" object serialiable before " + book.toString());
			out.println(" save serialiable .....");
			oos.writeObject(book);
			
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BookBeanSer.out"));
			out.println(" read serialiable ......");
			Object obj = ois.readObject();
			out.println(" object serialiable after " + obj.toString());
			ois.close();
		} catch (IOException e) {
			
		} catch (Exception e) {
			
		}
		
	}
}
