package com.java_concepts.matrix;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] mat = { { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 }, { 26, 27, 28, 29, 30 },
				{ 31, 32, 33, 34, 35 } };

		printMatrix(mat);

		System.out.println("Priting Spiral Order ");
		printSpiral(mat);
	}

	private static void printSpiral(int[][] mat) {

		int minRow = 0;
		int maxRow = mat.length - 1;
		int minCol = 0;
		int maxCol = mat[0].length - 1;

		while (minRow <= maxRow || minCol <= maxCol) {
			for (int i = minCol; i <= maxCol; i++) {
				System.out.print(mat[minRow][i] + "->");
			}
			minRow++;			
			
			for(int i = minRow; i <= maxRow; i++){
				System.out.print(mat[i][maxCol] + "->");
			}
			maxCol--;
			
			for (int i = maxCol; i >= minCol; --i) {
				System.out.print(mat[maxRow][i] + "->");
			}
			maxRow--;
			
			for (int i = maxRow; i >= minRow; --i){
				System.out.print(mat[i][minCol] + "->");
			}
			minCol++;
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
