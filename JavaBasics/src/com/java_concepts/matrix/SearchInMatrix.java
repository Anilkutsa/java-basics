package com.java_concepts.matrix;

/**
 * 
 * @author anil
 * 
 *         Write an efficient algorithm that searches for a value in an m x n
 *         matrix. This matrix has properties:
 * 
 *         1) Integers in each row are sorted from left to right.
 * 
 *         2) The first integer of each row is greater than the last integer of
 *         the previous row.
 * 
 *         Solution. Unique feature of this matrix is the right top element. All
 *         the elements to bottom are greater than it and all the elements to
 *         left are less than it. Using this feature navigate the whole matrix
 *         to find the element.
 *
 */

public class SearchInMatrix {
	class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{" + x + "," + y + "}";
		}
	}

	public static void main(String[] args) {
		new SearchInMatrix().init();
	}

	private void init() {
		int[][] mat = { { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 }, { 26, 27, 28, 29, 30 },
				{ 31, 32, 33, 34, 35 } };

		printMatrix(mat);

		System.out.println("Searching element " + mat[0].length);
		Node resultNode = searchElement(mat, 50, 0, mat[0].length - 1);
		if (resultNode != null)
			System.out.println("Found element at index " + resultNode.toString());
		else
			System.out.println("Element not found");
	}

	private Node searchElement(int[][] mat, int element, int row, int col) {

		if (row > mat.length - 1 || col > mat[0].length - 1) {
			return null;
		}
		System.out.println("Currently  at {" + row + "," + col + "}");
		int pivot = mat[row][col];

		if (pivot == element) {
			Node node = new Node(row, col);
			System.out.println("Found element " + node.toString());
			return node;
		} else if (element < pivot) {
			return searchElement(mat, element, row, --col);
		} else if (element > pivot) {
			return searchElement(mat, element, ++row, col);
		} else {
			return null;
		}
	}

	private void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
