// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.arithmetic.system;

/** 
 * className: TwoTree<br/>
 * Description: 二叉树<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月19日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class TwoTree {

	// 根节点
	private Node root;
	
	/**
	 * Description：查找<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @return
	 */
	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}
	
	/**
	 * Description：保存数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param key
	 * @param value
	 */
	public void insert(int key, double value) {
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent = null;
			while (true) {
				parent = current;
				if (current.iData > key) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = current;
		boolean is_right_flag = false;
		while (current.iData != key) {
			parent = current;
			if (current.iData > key) {
				current = current.leftChild;
				is_right_flag = false;
			} else {
				current = current.rightChild;
				is_right_flag = true;
			}
			if (current == null) {
				return false;
			}
		}
		
		// find current
		if(current.leftChild == null && current.rightChild == null) {
			// 不存在子节点
			if (current == root) {
				root = null;
			} else if (is_right_flag) {
				parent.rightChild = null;
			} else {
				parent.leftChild = null;
			}
		} else if (current.leftChild == null) {
			// 存在一个子节点
			if (current == root) {
				root = current.rightChild;
			} else if (is_right_flag) {
				parent.rightChild = current.rightChild;
			} else {
				parent.leftChild = current.rightChild;
			}
		} else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (is_right_flag) {
				parent.leftChild = current.rightChild;
			} else {
				parent.leftChild = current.leftChild;
			}
		} else {
			// 存在两个子节点
			// 查找后继节点
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if(is_right_flag) {
				parent.rightChild = successor;
			} else {
				parent.leftChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	/**
	 * Description：查找后继节点<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param delNode
	 * @return
	 */
	private Node getSuccessor(Node delNode) {
		Node sucessorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			sucessorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			sucessorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	/**
	 * Description：遍历最小值<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public Node minValue() {
		Node current = root;
		Node parent = current;
		while (current != null) {
			parent = current;
			current = current.leftChild;
		}
		return parent;
	}
	
	/**
	 * Description：遍历最大值<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @return
	 */
	public Node maxValue() {
		Node current = root;
		Node parent = current;
		while (current != null) {
			parent = current;
			current = current.rightChild;
		}
		return parent;
	}
	
	/**
	 * className: Node<br/>
	 * Description: <br/>
	 * Author: GW<br/>
	 * CreateTime： 2017年7月19日<br/>
	 *
	 * History: (version) Author DateTime Note <br/>
	 */
	class Node {
		int iData;
		double fData;
		Node leftChild;
		Node rightChild;
		
		public Node(int iData, double fData) {
			this.iData = iData;
			this.fData = fData;
		}

		/**
		 * @return the iData
		 */
		public int getiData() {
			return iData;
		}

		/**
		 * @param iData the iData to set
		 */
		public void setiData(int iData) {
			this.iData = iData;
		}

		/**
		 * @return the fData
		 */
		public double getfData() {
			return fData;
		}

		/**
		 * @param fData the fData to set
		 */
		public void setfData(double fData) {
			this.fData = fData;
		}

		/**
		 * @return the leftChild
		 */
		public Node getLeftChild() {
			return leftChild;
		}

		/**
		 * @param leftChild the leftChild to set
		 */
		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		/**
		 * @return the rightChild
		 */
		public Node getRightChild() {
			return rightChild;
		}

		/**
		 * @param rightChild the rightChild to set
		 */
		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	}
}
