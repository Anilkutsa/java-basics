package com.java_concepts.strings_arrays;

import java.util.Arrays;

/**
 * 
 * @author anil
 * 
 *         Two strings are isomorphic if the characters in s can be replaced to
 *         get t.
 */

public class IsomorphicStrings {

	public static void main(String[] args) {
		new IsomorphicStrings().init();
	}

	private void init() {
		System.out.println(isIsomorphic("aab", "eef")); // false
		//System.out.println(isIsomorphic("paper", "title")); // true
		//System.out.println(isIsomorphic("apple", "orange")); // false
	}

	public boolean isIsomorphic(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char characters[] = new char[26];
		char array1[] = string1.toCharArray();
		char array2[] = string2.toCharArray();

		for (int i = 0; i < array1.length; i++) {
			char c = array1[i];
			char character = characters[c - 'a'];
			
			/**
			 * Populate characters array. 
			 * array1 ascii value will hold with array2 element
			 */
			if (character == '\0') {
				characters[c - 'a'] = array2[i];
				continue;
			}
			
			/**
			 * If incase the characters array has value for array1 ascii value
			 * and that element is not equal to array2 element, condition fails
			 */
			if (character != array2[i]) {
				return false;
			}
		}
		System.out.println(Arrays.toString(characters));
		return true;
	}
}
