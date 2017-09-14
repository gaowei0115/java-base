// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.thread;

import java.util.Vector;

/** 
 * className: VectorTest<br/>
 * Description: Vector集合同步并发测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class VectorTest {
	static final Vector<Integer> vectors = new Vector<Integer>();

	public static void main(String[] args) {
		
		while (true) {
			for (int i = 0; i < 10; i++) {
				vectors.add(i);
			}
			
			Thread t1 = new Thread(new Runnable() {
				
				public void run() {
					for (int i = 0; i < vectors.size(); i++) {
						vectors.remove(i);
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				
				public void run() {
					for (int i = 0; i < vectors.size(); i++) {
						vectors.get(i);
					}
				}
			});
			
			t1.start();
			t2.start();
			
			while (Thread.activeCount() > 10) {
				
			}
		}
		
	}
}
