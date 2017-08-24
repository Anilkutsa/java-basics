package com.java_concepts.strings_arrays;

/**
 * 
 * @author anil
 *
 *         The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 *         number of rows like this: (you may want to display this pattern in a
 *         fixed font for better legibility)
 *         
 *         P A H N 
 *         APLSIIG 
 *         Y I R
 *         
 *         And then read line by line: "PAHNAPLSIIGYIR". 
 *         Write the a method convert("PAYPALISHIRING", 3) which returns "PAHNAPLSIIGYIR".
 */

public class ZigZagConversion {
	
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING", 5));
	}
	
	public static String convert(String oriStr, int numRows) {
		if (numRows == 1)
			return oriStr;
	 
		StringBuilder sb = new StringBuilder();
		//Standard formula for steps
		int step = 2 * numRows - 2;
	 
		for (int i = 0; i < numRows; i++) {
			//first & last rows
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < oriStr.length(); j = j + step) {
					System.out.println("i-" + i + ",j-" + j + ",Appending String-" + oriStr.charAt(j));
					sb.append(oriStr.charAt(j));
				}
			//middle rows	
			} else {
				int j = i;
				
				//This is needed for switching between steps
				boolean flag = true;
				
				//Standard formula for steps inbetween
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
				
				System.out.println("i-" + i + ",j-" + j + ",Appending String-" + oriStr.charAt(j) + ",Step1-"+step1 + ",Step2-" + step2);
	 
				while (j < oriStr.length()) {
					System.out.println("i-" + i + ",j-" + j + ",Appending String-" + oriStr.charAt(j)+">>>>>>>>>>>>>");
					sb.append(oriStr.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
		return sb.toString();
	}
}
