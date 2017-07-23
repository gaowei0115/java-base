// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.thread.pool.sample;

/** 
 * ClassName: PThread<br/>
 * Description: 线程池中复用线程，线程主体处于无限循环状态，该线程在手动关闭之前永不停止<br/>
 * Author: GW<br/>
 * Create： 2017年7月22日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class PThread extends Thread {

	// 线程池
	private ThreadPool threadPool;
	// 控制线程关闭
	private boolean isShutDown = false;
	// 执行线程
	private Runnable target;
	
	private boolean isIdle = false;
	
	/**
	 * Construtor()
	 * PThread.java
	 */
	public PThread() {
		
	}
	
	/**
	 * Construtor(@param name)
	 * PThread.java
	 */
	public PThread(String name) {
		super(name);
	}
	
	/**
	 * Construtor(@param target
	 * Construtor(@param name
	 * Construtor(@param threadPool)
	 * PThread.java
	 */
	public PThread(Runnable target, String name, ThreadPool threadPool) {
		super(name);
		this.target = target;
		this.threadPool = threadPool;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public Runnable getTarget() {
		return this.target;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public boolean isIdle() {
		return isIdle;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (!isShutDown) {
			// 若线程没有执行关闭则一直执行下去
			isIdle = false;
			if (target != null) {
				// 运行任务
				target.run();
			}
			// 任务执行结束 -- 表示该线程处于闲置状态
			isIdle = true;
			try {
				// 回收线程
				threadPool.repool(this);
				// 线程等待状态，线程加锁，只有同一个线程过来是锁才有效
				synchronized (this) {
					wait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Description：添加可执行线程，并唤醒等待线程<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param target
	 */
	public synchronized void setTarget(Runnable target) {
		this.target = target;
		notifyAll();
	}
	
	/**
	 * Description：关闭线程，唤醒等待线程执行，线程run方法会空执行一次之后停止被回收<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 */
	public void shutDown() {
		isShutDown = true;
		notifyAll();
	}
	
}
