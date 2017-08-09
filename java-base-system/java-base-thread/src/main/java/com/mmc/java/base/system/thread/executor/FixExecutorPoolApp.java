// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * className: ExecutorPoolApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月9日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class FixExecutorPoolApp {
	
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

	public static void main(String[] args) {
		
		System.out.println(ctl.get());
		System.out.println(workerCountOf(2));
		int c = ctl.get();
		System.out.println(c);
        int rs = runStateOf(c);
		System.out.println(rs);
		System.out.println(SHUTDOWN);
		int nThreads = 2;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		System.out.println("executor before .....");
		for (int i = 0; i < 4; i++) {
			executorService.execute(new ExecutorThread(i));
//			executorService.execute(null);
		}
		executorService.shutdown();
		System.out.println("executor after .....");
	}
}
