// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.sample.puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * className: SequentialPuzzleSolver<br/>
 * Description: 谜题框架串行解决方案<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SequentialPuzzleSolver<P, M> {

	// 谜题对象
	private final Puzzle<P, M> puzzle;
	// 目的位置集合
	private final Set<P> seen = new HashSet<P>();
	
	public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
		this.puzzle = puzzle;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public List<M> solve() {
		P pos = puzzle.initalPosition();
		return search(new PuzzleNode<P, M>(pos, null, null));
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param node
	 * @return
	 */
	private List<M> search(PuzzleNode<P, M> node) {
		if (!seen.contains(node.pos)) {
			seen.add(node.pos);
			if (puzzle.isGoal(node.pos)) {
				return node.asMoveList();
			}
			for (M move : puzzle.legalMoves(node.pos)) {
				P pos = puzzle.move(node.pos, move);
				PuzzleNode<P, M> child = new PuzzleNode<P, M>(pos, move, node);
				List<M> result = search(child);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

}
