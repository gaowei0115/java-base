// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.testframe;

import java.util.concurrent.BrokenBarrierException;

/** 
 * className: PutTakeModelTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月31日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class PutTakeModelTest {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		PutTakeModel putTakeModel = new PutTakeModel(10, 10, 10000);
		putTakeModel.testModel();
	}
}
