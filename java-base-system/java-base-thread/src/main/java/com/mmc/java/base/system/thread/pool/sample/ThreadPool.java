// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.sample;

import java.util.List;
import java.util.Vector;

/** 
 * ClassName: ThreadPool<br/>
 * Description: 自定义线程池<br/>
 * Author: GW<br/>
 * Create： 2017年7月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ThreadPool {

	/**
	 * 线程池中线程变量
	 */
	private static ThreadPool instance = null;
	// 集合实现线程池
	private List<PThread> threadPool;
	
	// 已有线程总数
	private int threadCount = 0;
	private boolean isShutDown = false;
	
	/**
	 * Construtor()
	 * ThreadPool.java
	 */
	private ThreadPool () {
		this.threadPool = new Vector<PThread>(10);
		threadCount = 0;
	}
	
	/**
	 * Description：获取创建线程数量<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public int createThreadCount() {
		return threadCount;
	}
	
	/**
	 * Description：单利模式获取对象，使用双重判定加锁形式保证多线程获取对象安全及性能<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public static ThreadPool instance() {
		if (instance == null) {
			synchronized (ThreadPool.class) {
				if (instance == null) {
					instance = new ThreadPool();
				}
				return instance;
			}
		}
		return instance;
	}
	
	/**
	 * Description：回放线程到线程池<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param pThread
	 */
	protected synchronized void repool(PThread pThread) {
		if (!isShutDown) {
			threadPool.add(pThread);
		} else {
			pThread.shutDown();
		}
	}
	
	/**
	 * Description：暂停线程池中所有线程<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public synchronized void shutDown() {
		isShutDown = true;
		int size = threadPool.size();
		for (int i = 0; i < size; i++) {
			PThread pThread = threadPool.get(i);	
			pThread.shutDown();
		}
	}
	
	/**
	 * Description：执行任务<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param target
	 */
	public void execute(Runnable target) {
		PThread pThread = null;
		// 如果存在空闲线程直接使用
		if (threadPool.size() > 0) {
			int index = threadPool.size() - 1;
			pThread = this.threadPool.get(index);
			threadPool.remove(index);
			// 执行任务
			pThread.setTarget(target);
		} else {
			// 不存在空余线程
			// 创建新线程
			this.threadCount++;
			pThread = new PThread(target, "PThread# " + this.threadCount, this);
			pThread.start();
		}
	}
}
