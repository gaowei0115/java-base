// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system.tree;

/** 
 * className: BaseTree<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月7日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public abstract class BaseTree<T> {

	protected Node[] elements;
	
	protected abstract void insert(T t);
	
	protected abstract T get(T key);
	
	protected abstract void delete(T key);
	
	/**
	 * className: Node<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年9月7日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	abstract class Node {
		private T t;
		private Node leftNode;
		private Node rightNode;
		
		/**
		 * 
		 */
		public Node(T t, Node leftNode, Node rightNode) {
			this.t = t;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}

		/**
		 * @return the t
		 */
		public T getT() {
			return t;
		}

		/**
		 * @param t the t to set
		 */
		public void setT(T t) {
			this.t = t;
		}

		/**
		 * @return the leftNode
		 */
		public Node getLeftNode() {
			return leftNode;
		}

		/**
		 * @param leftNode the leftNode to set
		 */
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		/**
		 * @return the rightNode
		 */
		public Node getRightNode() {
			return rightNode;
		}

		/**
		 * @param rightNode the rightNode to set
		 */
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
	}
}
