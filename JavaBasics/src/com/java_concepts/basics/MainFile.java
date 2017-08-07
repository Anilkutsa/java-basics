package com.java_concepts.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.java_concepts.datastructures.Stack;

public class MainFile {

    public static void main(String[] args) {
        MainFile main = new MainFile();
        //main.readFile();
        //main.strReverseMethod1("ANIL IS MAD");
        //main.strReverseMethod2(123456);
        //main.printPattern();        
    }

    public void readFile() {
        String fileText = null;
        try {
            fileText = new Scanner(new File("/home/anil/Desktop/dummy.txt")).useDelimiter("//Z").next();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        String[] str_array = fileText.split(" ");
        System.out.println("Length " + str_array.length);
        for (String s : str_array) {
            System.out.print(s + " ");
        }
    }

    public void strReverseMethod1(String str) {
        StringBuffer s = new StringBuffer();
        char[] c = str.toCharArray();
        int cLength = c.length - 1;
        for (int i = cLength; i > -1; i--) {
            s.append(c[i]);
        }
        System.out.println("String after reversing is " + s);
    }

    public void strReverseMethod2(int i) {
        int n = i;
        int rev = 0;
        while (n != 0) {
            System.out.println("n value " + rev);
            rev = rev * 10;
            rev = rev + n % 10;
            n = n / 10;
        }
        System.out.println("Final Value " + rev);
    }

    public void printPattern() {
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}
