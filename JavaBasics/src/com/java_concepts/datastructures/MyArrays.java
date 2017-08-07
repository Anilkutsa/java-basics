package com.java_concepts.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrays {
	
	int[] arr = {16, 17, 4, 3, 5, 2};
	
	/**
	 *  int[][] array = new int[1][1]; (LEGAL)
	 *  int array[][] = new int[1][1]; (LEGAL)
	 *  int array[1][1] = new int[][]; (NOT LEGAL)
	 */
	
	public static void main(String[] args){
		MyArrays arr = new MyArrays();
		arr.printLeader();
	}
	
	void printLeader(){
		int[] newArr = new int[arr.length];
		
		int index = arr.length - 1;
		int max = arr[index];
		newArr[index] = max;
		--index;
		
		while(index > -1){
			if(arr[index] > max){
				max = arr[index];
			}
			newArr[index] = max;
			--index;
		}
		System.out.println("Final Matrix " + Arrays.toString(newArr));
	}

}
