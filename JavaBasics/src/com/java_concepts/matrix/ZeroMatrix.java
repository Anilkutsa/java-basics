package com.java_concepts.matrix;

public class ZeroMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 1, 1 }, { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

		System.out.println("Input Matrix :");
		printMatrix(mat);

		// solutionWithExtraSpace(mat);
		spaceOptimisedSolution(mat);

		System.out.println("Matrix After Modification :");
		printMatrix(mat);
	}

	/**
	 * @param mat
	 *
	 *            In this method we allocate two arrays, one with size m to
	 *            store the row zero information, i.e, indicate which row is
	 *            zero, the other with size n to indicate which column is zero.
	 *            At last, we only need to copy those zeros into the original
	 *            array. It is obviously to see that the space complexity now
	 *            becomes O(m + n).
	 */
	private static void solutionWithExtraSpace(int mat[][]) {
		boolean[] row = new boolean[mat.length];
		boolean[] col = new boolean[mat[0].length];

		for (int m = 0; m < mat.length; m++) {
			for (int n = 0; n < mat[0].length; n++) {
				if (mat[m][n] == 0) {
					row[m] = true;
					col[n] = true;
				}
			}
		}

		for (int m = 0; m < mat.length; m++) {
			if (row[m] == true) {
				for (int n = 0; n < mat[0].length; n++) {
					mat[m][n] = 0;
				}
			}
		}

		for (int n = 0; n < mat[0].length; n++) {
			if (col[n] == true) {
				for (int m = 0; m < mat.length; m++) {
					mat[m][n] = 0;
				}
			}
		}
	}

	/**
	 * @param mat
	 * 
	 *            Constant Space Solution: Since the problem asks for a constant
	 *            space solution, we must think of one without allocating
	 *            additional space. Remember in last solution, we used
	 *            additional row and column to store the zero information. How
	 *            about we use the first column and row to save the zero
	 *            information? It sounds doable. But what about the first or
	 *            column contains zeros thus needs to be set as zeros as well?
	 *            We could work around by using a flag to mark the first row or
	 *            column as zeros.
	 */
	public static void spaceOptimisedSolution(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		boolean firstRowZero = false;
		boolean firstColZero = false;

		for (int i = 0; i < n; i++) {
			if (mat[0][i] == 0) {
				firstRowZero = true;
			}
		}

		for (int i = 0; i < m; i++) {
			if (mat[i][0] == 0) {
				firstColZero = true;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if ((mat[i][0] == 0) || (mat[0][j] == 0)) {
					mat[i][j] = 0;
				}
			}
		}

		if (firstRowZero) {
			for (int i = 0; i < n; i++) {
				mat[0][i] = 0;
			}
		}

		if (firstColZero) {
			for (int i = 0; i < m; i++) {
				mat[i][0] = 0;
			}
		}
	}

	/* A utility function to print a 2D matrix */
	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}

}
