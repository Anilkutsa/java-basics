package com.java_concepts.strings_arrays;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("Red rum, sir, is murder"));
		System.out.println(pal.isValidPalindrome("Red rum, sir, is murder"));
	}

	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		System.out.println(s);

		int len = s.length();
		if (len < 2)
			return true;

		Stack<Character> stack = new Stack<Character>();

		int index = 0;
		while (index < len / 2) {
			stack.push(s.charAt(index));
			index++;
		}

		if (len % 2 == 1)
			index++;

		while (index < len) {
			if (stack.empty())
				return false;

			char temp = stack.pop();
			if (s.charAt(index) != temp)
				return false;
			else
				index++;
		}
		return true;
	}

	public static boolean isValidPalindrome(String s) {
		if (s == null || s.length() == 0)
			return false;

		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
