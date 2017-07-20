// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.masterworker;

import java.util.Map;

/** 
 * className: MainApp<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月20日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class MainApp {

	public static void main(String[] args) {
		Master master = new Master(new PlusWorker(), 10);
		
		for (int i = 0; i < 100; i++) {
			master.submit(i);
		}
		
		master.execute();
		
		int re = 0;
		Map<String, Object> resultMap = master.resultMap;
		
		while (resultMap.size() > 0 || !master.isComplete()) {
			String key = null;
			for (String k : resultMap.keySet()) {
				key = k;
				break;
			}
			if (key != null) {
				Integer i = (Integer)resultMap.get(key);
				if (i != null) {
					re += i;
				}
			}
			resultMap.remove(key);
		}
		System.out.println("计算结果：" + re);
	}
}
