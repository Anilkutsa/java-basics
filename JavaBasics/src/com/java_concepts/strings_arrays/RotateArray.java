package com.java_concepts.strings_arrays;

import java.util.Arrays;

/**
 * @author anil
 *
 *         Rotate array by K elements
 */

public class RotateArray {

	public static void main(String[] args) {
		new RotateArray().init();
	}

	private void init() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		// rotate(arr, 3);
		// bubbleRotate(arr, 3);
		rotateUsingReverse(arr, 3);
	}

	/**
	 * BRUTE FORCE METHOD. SPACE CONSTRAINT - O(N). TIME CONSTAINT - O(N)
	 * 
	 * @param array
	 * @param k
	 */
	private void rotate(int[] array, int k) {
		if (k > array.length)
			k = k % array.length;

		// Create a temp array and shift last k elements of original array
		// to starting of temp array
		int[] temp = new int[array.length];
		for (int i = 0; i < k; i++) {
			temp[i] = array[array.length - k + i];
		}

		// Now start from k'th position in temp array and copy original array
		// elements from start to original array length-k position
		int j = 0;
		for (int i = k; i < array.length; i++) {
			temp[i] = array[j];
			j++;
		}

		// Copy temp elements to original array
		System.arraycopy(temp, 0, array, 0, array.length);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * BUBBLE ROTATE METHOD. SPACE CONSTRAINT - O(1) In this we will bubble up
	 * the last digit to first position We will carry this for k number of
	 * iterations
	 * 
	 * @param array
	 * @param k
	 */
	private void bubbleRotate(int[] array, int k) {
		if (array == null || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (k > array.length) {
			k = k % array.length;
		}

		for (int i = 0; i < k; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				System.out.println("i " + i + " j " + j + " " + Arrays.toString(array));
			}
		}
		System.out.println(Arrays.toString(array));
	}

	/**
	 * Divide the array two parts: 1,2,3,4 and 5, 6 2. Reverse first part:
	 * 4,3,2,1,5,6 3. Reverse second part: 4,3,2,1,6,5 4. Reverse the whole
	 * array: 5,6,1,2,3,4
	 * 
	 * @param array
	 * @param k
	 */
	private void rotateUsingReverse(int[] array, int k) {
		if (array == null || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (k > array.length) {
			k = k % array.length;
		}

		reverseArray(0, (array.length - 1) - k, array);
		System.out.println(Arrays.toString(array));
		reverseArray((array.length - k), array.length - 1, array);
		System.out.println(Arrays.toString(array));
		reverseArray(0, array.length - 1, array);
		System.out.println(Arrays.toString(array));
	}

	private void reverseArray(int start, int end, int[] array) {
		if (array == null || array.length == 1)
			return;

		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
