package com.java_concepts.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

import com.java_concepts.datastructures.BinaryTree.Queue;

public class BST {
	Node root;

	BST() {
		root = null;
	}

	public static void main(String[] args) {
		/**              
		 * 			10
		 * 		   /  \
		 * 		  5    20
		 * 	     / \   / \
		 * 	    1   7 15 22
		 * 			  /
		 * 			 12
		 */ 
		
		BST tree = new BST();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(20);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(22);
		tree.root.right.left.left = new Node(12);

		tree.printInorder(tree.root);

		System.out.println("Check if tree is BST - ");
		tree.checkIfBST(tree.root);

		System.out.println("Print level order elements - ");
		tree.printLevelOrderElements(tree.root);
	}
	
	void printLevelOrderElements(Node node){
		
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(node);
		
		Node markerNode = new Node(999);
		queue.enqueue(markerNode);
		
		Node current = null;
		
		while(!queue.isEmpty()){	
			current = queue.dequeue();
			
			if(current != markerNode){
				System.out.print(current.data + "");
				
				if(current.left != null)
					queue.enqueue(current.left);
				
				if(current.right !=null)
					queue.enqueue(current.right);
			} else {
				System.out.println("Found Marker Node");
				queue.enqueue(markerNode);
			}
		}
	}

	void checkIfBST(Node node) {
		System.out.println(checkIfBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	boolean checkIfBSTUtil(Node node, int low, int high) {
		if (node == null) {
			return true;
		}

		if (node.data < low || node.data > high) {
			return false;
		}

		return checkIfBSTUtil(node.left, low, node.data) && checkIfBSTUtil(node.right, node.data, high);
	}

	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
	
	class Queue<T> {

		Deque<T> deque = new ArrayDeque<T>();

		void enqueue(T t) {
			deque.addFirst(t);
		}

		T dequeue() {
			return deque.removeLast();
		}

		T peek() {
			return deque.peekLast();
		}

		boolean isEmpty() {
			return deque.isEmpty();
		}
	}

}
