// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.sample.puzzle;

import java.util.LinkedList;
import java.util.List;

/** 
 * className: PuzzleNode<br/>
 * Description: 谜题Node节点<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class PuzzleNode<P, M> {

	final P pos;
	final M move;
	final PuzzleNode<P, M> prev;
	
	/**
	 * @param pos
	 * @param move
	 * @param pre
	 */
	public PuzzleNode(P pos, M move, PuzzleNode<P, M> pre) {
		this.pos = pos;
		this.move = move;
		this.prev = pre;
	}
	
	/**
	 * Description：获取所有移动点<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	List<M> asMoveList() {
		List<M> solution = new LinkedList<M>();
		for (PuzzleNode<P, M> node = this; node.move != null; node = node.prev) {
			solution.add(node.move);
		}
		return solution;
	}
}
