package com.sundance.algorithm.tree;

public class Node {

	private Node left;
	private Node right;
	private int value;

	public Node(int value){
		this.value = value;
	}




	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}




	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}




	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}




	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}




	public String toString(){
		return String.valueOf(this.value);
	}


	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
}
