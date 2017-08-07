package com.java_concepts.datastructures;

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;
	static int preIndex = 0;

	void newNode(int data) {
		Node node = new Node(data);
	}

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(6);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(9);
		tree.root.left.right = new Node(1);
		tree.root.right.left = new Node(2);
		tree.root.right.right = new Node(3);
		tree.root.right.left.left = new Node(8);

		System.out.println("Inorder traversal - ");
		tree.printInorder(tree.root);

		System.out.println("\nPreorder traversal - ");
		tree.printPreOrder(tree.root);

		System.out.println("\nPostorder traversal - ");
		tree.printPostOrder(tree.root);

		System.out.println("\nBFS traversal - ");
		tree.printBFS(tree.root);

		System.out.println("\nDimater of the tree - " + tree.findDiameter(tree.root));

		int in[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		int pre[] = new int[] { 1, 2, 4, 5, 3, 6, 7 };
		int len = in.length;
		Node root = tree.buildTree(in, pre, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);

		// Size of the binary tree
		System.out.println("Size of the tree is : " + tree.getSize(tree.root));

		// Height of the binary tree
		System.out.println("Height of the tree is : " + tree.getHeight(tree.root));

		System.out.println("Sum from root to leaf node is - ");
		tree.printSumRootToLeaf(tree.root, 0);
	}
	
	

	void printSumRootToLeaf(Node node, int sum) {
		if (node == null)
			return;

		if (node.left == null && node.right == null) {
			sum = sum + node.data;
			System.out.println("Total Sum is - " + sum);
			return;
		}
		printSumRootToLeaf(node.left, node.data + sum);
		printSumRootToLeaf(node.right, node.data + sum);
		return;
	}

	int getSize(Node node) {
		if (node == null) {
			return 0;
		}
		int left = getSize(node.left);
		int right = getSize(node.right);
		return left + right + 1;
	}

	int getHeight(Node node) {
		if (node == null) {
			return 0;
		}

		int left = getHeight(node.left);
		int right = getHeight(node.right);
		if (left > right)
			return left;
		else if (right > left)
			return right;

		return left + 1;
	}

	Node buildTree(int in[], int pre[], int inStrt, int inEnd) {

		if (inStrt > inEnd)
			return null;

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		Node tNode = new Node(pre[preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, tNode.data);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

		return tNode;
	}

	int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}

	void printBFS(Node node) {

		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			Node n = queue.dequeue();
			System.out.print(n.data + " ");

			if (n.left != null)
				queue.enqueue(n.left);

			if (n.right != null)
				queue.enqueue(n.right);
		}
	}

	int findDiameter(Node node) {
		if (node == null) {
			return 0;
		}

		int left = 1 + findDiameter(node.left);
		int right = 1 + findDiameter(node.right);

		if (left > right) {
			return left;
		}
		return right;
	}

	void printInorderWithStack(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}

	}

	void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	void printPreOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	void printPostOrder(Node node) {
		if (node == null)
			return;

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
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
