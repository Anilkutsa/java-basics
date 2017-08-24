package com.java_concepts.matrix;

/**
 * @author anil
 * 
 *         Given a m x n grid filled with non-negative numbers, find a path from
 *         top left to bottom right which minimizes the sum of all numbers along
 *         its path.
 * 
 *         Solution. Use dynamic programming to solve this problem.
 */

public class MinCostPath {

	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 }, { 1, 2, 1, 2 } };

		System.out.println("Printing Matrix ");
		printMatrix(mat);

		System.out.println("Constructing new matrix -  ");
		findMinPath(mat);
	}

	private static void findMinPath(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int[][] newMat = new int[row][col];
		newMat[0][0] = mat[0][0];

		for (int i = 1; i < row; i++) {
			newMat[i][0] = newMat[i - 1][0] + mat[i][0];
		}

		for (int i = 1; i < col; i++) {
			newMat[0][i] = newMat[0][i - 1] + mat[0][i];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (newMat[i][j - 1] >= newMat[i - 1][j]) {
					newMat[i][j] = newMat[i - 1][j] + mat[i][j];
				} else {
					newMat[i][j] = newMat[i][j - 1] + mat[i][j];
				}
			}
		}

		printMatrix(newMat);
		printMinPath(mat, newMat);
	}

	private static void printMinPath(int[][] oriMat, int[][] pathMat) {
		System.out.println("Printing Min Path - ");

		int row = pathMat.length - 1;
		int col = pathMat[0].length - 1;

		while (row > -1 && col > -1) {
			// System.out.println("Currently at {" + x + "," + y + "}");

			// If reached top row, keep navigating left
			if (row == 0) {
				System.out.print(oriMat[row][col] + " ");
				--col;
				continue;
			}

			// If reached left column, keep naviagating top
			if (col == 0) {
				System.out.print(oriMat[row][col] + " ");
				--row;
				continue;
			}

			if (pathMat[row][col - 1] < pathMat[row - 1][col]) {
				// If left is less then top, print left and move left
				System.out.print(oriMat[row][col] + " ");
				--col;

			} else {
				// If left is less then top, print left and move leftF
				System.out.print(oriMat[row][col] + " ");
				--row;
			}
		}

	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
