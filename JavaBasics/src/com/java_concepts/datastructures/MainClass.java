package com.java_concepts.datastructures;

import java.util.Scanner;

public class MainClass {

    static int arraySize;
    static int[] array;

    public static void main(String[] args) {
    	
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array ");
        int arraySize = s.nextInt();
        int[] array = new int[arraySize];
        System.out.println("Enter the array elements ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = s.nextInt();
        }
        System.out.print("Reverse array elements are - ");
        for(int i = array.length-1; i > -1; --i){
            System.out.print(" " + array[i]);
        }
    }
}
