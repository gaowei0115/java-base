// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.sample.puzzle;

import java.util.Set;

/** 
 * className: Puzzle<br/>
 * Description: 谜题抽象类<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public interface Puzzle<P, M> {

	/**
	 * Description：初始化位置<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	P initalPosition();
	
	/**
	 * Description：目标位置<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param position
	 * @return
	 */
	boolean isGoal(P position);
	
	/**
	 * Description：有效移动结果集<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param postion
	 * @return
	 */
	Set<M> legalMoves(P postion);
	
	/**
	 * Description：移动位置<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param position
	 * @param move
	 * @return
	 */
	P move(P position, M move);
	
}
