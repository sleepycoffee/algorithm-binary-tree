package com.sundance.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void run() {
		// build the simple tree from chapter 11.
		Node root = new Node(5);
		System.out.println("Binary Tree Example");
		System.out.println("Building tree with root value " + root.getValue());

		System.out.println("Insert " + insertNode(root, 1).toString());
		System.out.println("Insert " + insertNode(root, 8).toString());
		System.out.println("Insert " + insertNode(root, 6).toString());
		System.out.println("Insert " + insertNode(root, 3).toString());
		System.out.println("Insert " + insertNode(root, 20).toString());
		System.out.println("Insert " + insertNode(root, 15).toString());
		System.out.println("Insert " + insertNode(root, 9).toString());
		System.out.println();
		
		System.out.println("Getting all children for node:\t" + root.getValue());
		List<Node> nodes = getAllChildren(root);
		if(nodes != null && !nodes.isEmpty()) {
			for(Node node: nodes) {
				System.out.print(node.getValue() + "\t");
			}
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Traversing tree in order");
		nodes = getAllChildrenInOrder(root);
		if(nodes != null && !nodes.isEmpty()) {
			for(Node node: nodes) {
				System.out.print(node.getValue() + "\t");
			}
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Traversing tree pre order");
		nodes = getAllChildrenPreOrder(root);
		if(nodes != null && !nodes.isEmpty()) {
			for(Node node: nodes) {
				System.out.print(node.getValue() + "\t");
			}
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Traversing tree post order");
		nodes = getAllChildrenPostOrder(root);
		if(nodes != null && !nodes.isEmpty()) {
			for(Node node: nodes) {
				System.out.print(node.getValue() + "\t");
			}
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Traversing tree in order");
		printInOrder(root);
		System.out.println("Traversing tree front-to-back from location 7");
		printFrontToBack(root, 7);
		System.out.println();

	}

	public void insert(Node node, int value) {

		if (value < node.getValue()) {
			if (node.getLeft() != null) {
				insert(node.getLeft(), value);
			} else {
				System.out.println("  Inserted " + value + " to left of "
						+ node.getValue());
				node.setLeft(new Node(value));
			}
		} else if (value > node.getValue()) {
			if (node.getRight() != null) {
				insert(node.getRight(), value);
			} else {
				System.out.println("  Inserted " + value + " to right of "
						+ node.getValue());
				node.setRight(new Node(value));
			}
		}
	}

	/** root, left, right */
	public List<Node> getAllChildren(Node node) {

		if (node == null) {
			return null;
		}

		List<Node> nodes = new ArrayList<Node>();

		Node left = node.getLeft();
		if(left != null) {
			nodes.add(left);
			nodes.addAll(getAllChildren(left));
		}

		Node right = node.getRight();
		if(right != null) {
			nodes.add(right);
			nodes.addAll(getAllChildren(right));
		}

		return nodes;
	}

	/** left, root, right */
	public List<Node> getAllChildrenInOrder(Node node) {

		if (node == null) {
			return null;
		}
		
		List<Node> nodes = new ArrayList<Node>();

		Node left = node.getLeft();
		if(left != null) {
			nodes.addAll(getAllChildrenInOrder(left));
		}

		nodes.add(node);

		Node right = node.getRight();
		if(right != null) {
			nodes.addAll(getAllChildrenInOrder(right));
		}

		return nodes;
		
	}

	/** root, left, right */
	public List<Node> getAllChildrenPreOrder(Node node) {

		if (node == null) {
			return null;
		}
		
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(node);

		Node left = node.getLeft();
		if(left != null) {
			nodes.addAll(getAllChildrenPreOrder(left));
		}

		Node right = node.getRight();
		if(right != null) {
			nodes.addAll(getAllChildrenPreOrder(right));
		}

		return nodes;
		
	}

	/** root, left, right */
	public List<Node> getAllChildrenPostOrder(Node node) {

		if (node == null) {
			return null;
		}
		
		List<Node> nodes = new ArrayList<Node>();

		Node left = node.getLeft();
		if(left != null) {
			nodes.addAll(getAllChildrenPostOrder(left));
		}

		Node right = node.getRight();
		if(right != null) {
			nodes.addAll(getAllChildrenPostOrder(right));
		}

		nodes.add(node);
		
		return nodes;
	}

	public Node insertNode(Node node, int value) {

		if(node == null) {
			return null;
		}

		if(node.getValue() == value) {
			return null;
		}

		Node child = new Node(value);

		if(value < node.getValue()) {
			if(node.getLeft() != null) {
				insertNode(node.getLeft(), value);
			} else {
				node.setLeft(child);
			}
		} else {
			if(node.getRight() != null) {
				insertNode(node.getRight(), value);
			} else {
				node.setRight(child);
			}

		}
		return child;
	}
	
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.println("  Traversed " + node.getValue());
			printInOrder(node.getRight());
		}
	}
	
	/**
	 * uses in-order traversal when the origin is less than the node's value
	 * 
	 * uses reverse-order traversal when the origin is greater than the node's
	 * order
	 */
	public void printFrontToBack(Node node, int camera) {
		if (node == null)
			return;
		if (node.getValue() > camera) {
			// print in order
			printFrontToBack(node.getLeft(), camera);
			System.out.println("  Traversed " + node.getValue());
			printFrontToBack(node.getRight(), camera);
		} else if (node.getValue() < camera) {
			// print reverse order
			printFrontToBack(node.getRight(), camera);
			System.out.println("  Traversed " + node.getValue());
			printFrontToBack(node.getLeft(), camera);
		} else {
			// order doesn't matter
			printFrontToBack(node.getLeft(), camera);
			printFrontToBack(node.getRight(), camera);
		}
	}

}
