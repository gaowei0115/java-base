// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.future.callable;

import java.util.concurrent.FutureTask;

/** 
 * className: FutuThreadTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月7日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class FutuThreadTest {

	public static void main(String[] args) throws Exception {
		FutureTask<String> futureTask = new FutureTask<String>(new FutuTask());
		
		new Thread(futureTask).start();
		
		String str = futureTask.get();
		
		System.out.println(str);
	}
}
