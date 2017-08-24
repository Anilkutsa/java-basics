package com.java_concepts.strings_arrays;

import java.util.*;

/**
 * 
 * @author anil
 * 
 *         Given an unsorted array of integers, find the length of the longest
 *         consecutive elements sequence.
 * 
 *         For example, given [100, 4, 200, 1, 3, 2], the longest consecutive
 *         elements sequence should be [1, 2, 3, 4]. Its length is 4.
 * 
 *         Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] i = { 100, 4, 200, 1, 3, 2 };
		System.out.println(lcs.findLongestConsecutive(i));
	}

	public static int findLongestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int e : num)
			set.add(e);

		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;

			System.out.println("Num - " + e + ",Left-" + left + ",Right-" + right + ",Count-" + count);

			while (set.contains(left)) {
				count++;
				set.remove(left);
				System.out.println("Found " + left + ",Count-" + count + ", removing element");
				left--;
			}

			while (set.contains(right)) {
				count++;
				set.remove(right);
				System.out.println("Found " + right + ",Count-" + count + ", removing element");
				right++;
			}

			max = Math.max(count, max);
		}

		return max;
	}
}
