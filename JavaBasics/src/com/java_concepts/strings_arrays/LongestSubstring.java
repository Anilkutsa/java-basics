package com.java_concepts.strings_arrays;

import java.util.*;

/**
 * 
 * @author anil
 *
 *         You are given a string, s, and a list of words, words, that are all
 *         of the same length. Find all starting indices of substring(s) in s
 *         that is a concatenation of each word in words exactly once and
 *         without any intervening characters.
 * 
 *         For example, given: s="barfoothefoobarman" & words=["foo", "bar"],
 *         return [0,9].
 */

public class LongestSubstring {

	public static void main(String[] args) {
		ArrayList<Integer> result = findSubstring("barfoothefoobarman", new String[] { "foo", "bar" });
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static ArrayList<Integer> findSubstring(String originalString, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (originalString == null || originalString.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		// frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String w : words) {
			if (map.containsKey(w)) {
				map.put(w, map.get(w) + 1);
			} else {
				map.put(w, 1);
			}
		}

		int len = words[0].length();

		for (int j = 0; j < len; j++) {
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
			int start = j;// start index of start
			int count = 0;// count total qualified words so far

			for (int i = j; i <= originalString.length() - len; i = i + len) {
				String sub = originalString.substring(i, i + len);
				if (map.containsKey(sub)) {
					// set frequency in current map
					if (currentMap.containsKey(sub)) {
						currentMap.put(sub, currentMap.get(sub) + 1);
					} else {
						currentMap.put(sub, 1);
					}

					count++;

					while (currentMap.get(sub) > map.get(sub)) {
						String left = originalString.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);

						count--;
						start = start + len;
					}

					if (count == words.length) {
						result.add(start); // add to result

						// shift right and reset currentMap, count & start point
						String left = originalString.substring(start, start + len);
						currentMap.put(left, currentMap.get(left) - 1);
						count--;
						start = start + len;
					}
				} else {
					currentMap.clear();
					start = i + len;
					count = 0;
				}
			}
		}

		return result;
	}
}
