// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.concurrent;

/** 
 * className: ConcurrentHashMapLocked<br/>
 * Description: 模拟ConcurrentHashMap中使用Locked锁实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月21日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ConcurrentHashMapLocked {

	public final static int DEFAULT_LOCKED = 16;
	
	static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
	
	public final static int n = 100;
	
	public final Node[] elements;
	
	public final Object[] locks;
	
	private volatile int size;
	
	
	static class Node {
		private int hash;
		private String value;
		
		public Node(int hashinit, String valueinit) {
			this.hash = hashinit;
			this.value = valueinit;
		}

		/**
		 * @return the hash
		 */
		public int getHash() {
			return hash;
		}

		/**
		 * @param hash the hash to set
		 */
		public void setHash(int hash) {
			this.hash = hash;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	public ConcurrentHashMapLocked(int sizeinit) {
		elements = new Node[sizeinit];
		locks = new Object[DEFAULT_LOCKED];
		for (int i = 0; i < DEFAULT_LOCKED; i++) {
			locks[i] = new Object();
		}
	}
	
	/**
	 * Description：计算hash值<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param h
	 * @return
	 */
	public int speed(int h) {
		return (n - 1) & (h ^ (h >>> 16)) & HASH_BITS;
	}
	
	/**
	 * Description：模拟保存数据加锁<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 */
	public void put(String key, String value) {
		// 使用分散加锁
		int hash = speed(key.hashCode());
		synchronized (locks[hash % n]) {
			elements[hash] = new Node(hash, value);
			size++;
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @return
	 */
	public String get(String key) {
		int hash = speed(key.hashCode());
		synchronized(locks[hash % n]) {
			return elements[hash].getValue();
		}
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			synchronized(locks[i % n]) {
				elements[i] = null;
			}
		}
	}
	
	private static int hash(String key) {
		int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	public static void main(String[] args) {
		int h = 0;
		String key = "456";
		int hash = 16 & ((h = key.hashCode()) ^ (h >>> 16));
		System.out.println(hash);
		System.out.println(16 << 1);
		System.out.println((15) & hash("123"));
	}
	
}
