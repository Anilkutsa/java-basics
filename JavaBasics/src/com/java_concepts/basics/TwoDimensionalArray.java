package com.java_concepts.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDimensionalArray {

	public static void main(String[] args) throws IOException {

		TwoDimensionalArray obj = new TwoDimensionalArray();

		int matrix[][] = { { 1, 1, 1 }, { 0, 1, 0 }, { 1, 1, 1 } };
		obj.printArray(matrix);
	}

	private void printArray(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
