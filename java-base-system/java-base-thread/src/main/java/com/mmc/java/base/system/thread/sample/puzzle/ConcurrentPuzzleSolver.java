// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.thread.sample.puzzle;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * className: ConcurrentPuzzleSolver<br/>
 * Description: 谜题框架并行解决方案<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月16日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ConcurrentPuzzleSolver<P, M> {

	private final Puzzle<P, M> puzzle;
	private final ExecutorService executor;
	private final ConcurrentMap<P, Boolean> seen;
	final ValueLatch<PuzzleNode<P, M>> solution = new ValueLatch<PuzzleNode<P,M>>();
	
	public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle) {
		this.puzzle = puzzle;
		executor = Executors.newCachedThreadPool();
		this.seen = new ConcurrentHashMap<P, Boolean>();
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public List<M> solve() {
		try {
			P p = puzzle.initalPosition();
			executor.execute(new SolverTask(p, null, null));
			PuzzleNode<P, M> solnNode = solution.getValue();
			return (solnNode == null) ? null : solnNode.asMoveList();
		} catch (Exception e) {
			
		} finally {
			executor.shutdown();
		}
		return null;
	}
	
	/**
	 * className: SolverTask<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年8月16日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	protected class SolverTask extends PuzzleNode<P, M> implements Runnable {

		/**
		 * @param pos
		 * @param move
		 * @param pre
		 */
		public SolverTask(P pos, M move, PuzzleNode<P, M> pre) {
			super(pos, move, pre);
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			if (solution.isSet() || seen.putIfAbsent(pos, true) != null) {
				return;
			}
			if (puzzle.isGoal(pos)) {
				solution.setValue(this);
			} else {
				for (M m : puzzle.legalMoves(pos)) {
					executor.execute(new SolverTask(puzzle.move(pos, m), m, this));
				}
			}
		}
		
	}
	
}
