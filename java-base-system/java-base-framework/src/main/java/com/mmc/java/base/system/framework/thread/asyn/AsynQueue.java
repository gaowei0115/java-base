// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.framework.thread.asyn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * className: AsynQueue<br/>
 * Description: 异步缓存队列<br/>
 * 			Map<String, BlockingQueue>实现
 * 			Long:指定某个用户的共享的队列ID
 * 			BlockingQueue: 指定缓存线程区
 * Author: GW<br/>
 * CreateTime： 2017年9月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class AsynQueue {

	// 默认缓存队列大小
	private static final int DEFAULT_CAPACITY = 64;
	
	private final Map<String, BlockingQueue<Runnable>> cache;
	// 锁
	private static final Lock lock = new ReentrantLock();
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private AsynQueue() {
		this.cache = new ConcurrentHashMap<String, BlockingQueue<Runnable>>();
	}
	
	public static String[] baseString={"0","1","2","3",
            "4","5","6","7","8","9",
            "a","b","c","d","e",
            "f","g","h","i","j",
            "k","l","m","n","o",
            "p","q","r","s","t",
            "u","v","w","x","y",
            "z","A","B","C","D",
            "E","F","G","H","I",
            "J","K","L","M","N",
            "O","P","Q","R","S",
            "T","U","V","W","X","Y","Z"};
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public static AsynQueue getInstance() {
		try {
			if (lock.tryLock()) {
				return new AsynQueue();
			}
		} finally {
			lock.unlock();
		}
		return null;
	}
	
	/**
	 * Description：加入队列<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @param task
	 */
	protected void push(String key, Runnable task) {
		if (cache.containsKey(key)) {
			cache.get(key).offer(task);
		} else {
			BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(DEFAULT_CAPACITY);
			queue.offer(task);
			cache.put(key, queue);
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	protected boolean isEmpty() {
		for (String key : cache.keySet()) {
			if (cache.get(key).size() != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Description：从队列中获取元素<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	protected Runnable poll(String key) {
		if (cache.get(key) != null) {
			return cache.get(key).poll();
		}
		return null;
	}
	
	/**
	 * Description：获取序列号<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	protected String serialNum() {
		StringBuilder sb = new StringBuilder();
		String time = sdf.format(new Date());
		sb.append(time);
		Random random = new Random();
        int length=baseString.length;
        String randomString="";
        for(int i=0;i<length;i++){
            randomString+=baseString[random.nextInt(length)];
        }
        
        String result = "";
        for (int i = 0; i < 6; i++) {
        	result += randomString.charAt(random.nextInt(randomString.length()-1));
        }
        sb.append(result);
        return sb.toString();
	}
}
