package com.java_concepts.matrix;

/**
 * @author anil
 *
 * Given a 2D array, find unique paths from [0][0] to [m-1][n-1] given
 * obstacles. For Ex. Below array has 4 unique paths from source to destination.
 *         0 0 0 0
 *         0 0 1 0 
 *         0 0 0 0 
 *  
 *  Solution - 
 *  Create a duplicate array of same size as original. 
 *  Mark source index as 1. 
 *  
 *  Mark all left elements as 1 if no obstacles above. If obstacles found, all below elements are 0. 
 *  Mark all top elements as 1 if no obstacles in the left. If obstacles found, all right elements are 0.
 *  
 *  Now, use below loop and populate the array 
 *  if(element == obstacle)
 *  	Mark the elements with obstacles as 0. 
 *  else 
 *   	element = top + left
 * 
 * Return destination 
 */

public class UniquePathsWithObstacles {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		System.out.println(findUniquePathsWithObstacles(arr));
	}

	public static int findUniquePathsWithObstacles(int[][] original) {
		if (original == null || original.length == 0)
			return 0;

		int m = original.length;
		int n = original[0].length;

		if (original[0][0] == 1 || original[m - 1][n - 1] == 1)
			return 0;

		int[][] duplicate = new int[m][n];
		duplicate[0][0] = 1;

		// left column
		for (int i = 1; i < m; i++) {
			if (original[i][0] == 1) {
				duplicate[i][0] = 0;
			} else {
				duplicate[i][0] = duplicate[i - 1][0];
			}
		}

		// top row
		for (int i = 1; i < n; i++) {
			if (original[0][i] == 1) {
				duplicate[0][i] = 0;
			} else {
				duplicate[0][i] = duplicate[0][i - 1];
			}
		}

		// fill up cells inside
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (original[i][j] == 1) {
					duplicate[i][j] = 0;
				} else {
					duplicate[i][j] = duplicate[i - 1][j] + duplicate[i][j - 1];
				}

			}
		}

		return duplicate[m - 1][n - 1];
	}
}
