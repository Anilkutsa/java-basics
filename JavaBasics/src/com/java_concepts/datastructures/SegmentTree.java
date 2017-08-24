package com.java_concepts.datastructures;

import java.util.Arrays;

/**
 * 
 * @author anil
 * 
 *         MINIMUM RANGE QUERY
 * 
 *         First we assign the values of the array to leaves of a Binary Tree
 *         Then we start constructing the tree upwards till we reach the root
 * 
 *         Construct a segment array with above tree values. The size
 *         of this array will be as follows - ==> If the size of initial array
 *         is power of 2, the segment array size is (PowerOf2 x 2 - 1) ==> If
 *         the size of initial array is not a power of 2, take the next power of
 *         2. (NextPowerOf2 x 2 - 1)
 * 
 *         Given a element in segment array, use below formulas for its
 *         properties - 1. 2i+1 = Left Child 2. 2i+2 = Right Child 3. (i-1)/2 =
 *         Parent
 * 
 *         Now, given a range query, i.e., find minimum between a range, we may
 *         encounter three situations 1. Partial Overlap (START searching both
 *         the child NODES) 2. Total Overlap (STOP and return the NODE value) 3.
 *         No Overlap (STOP and return MAX value)
 * 
 *         TIME COMPLEXITY - O(4logN) = O(logN) SPACE COMPLEXITY - O(N)
 */

public class SegmentTree {

	public static void main(String[] args) {
		SegmentTree st = new SegmentTree();

		int input[] = { 0, 3, 4, 2, 1, 6, -1 };
		int segTree[] = st.createSegmentTree(input);

		System.out.println("Segment Array is - " + Arrays.toString(segTree));

		// non lazy propagation example
		System.out.println(st.rangeMinimumQuery(segTree, 0, 3, input.length));
		System.out.println(st.rangeMinimumQuery(segTree, 1, 5, input.length));
		System.out.println(st.rangeMinimumQuery(segTree, 1, 6, input.length));
	}

	/**
	 * if input len is pow of 2 then size of segment tree is 2*len - 1,
	 * otherwise size of segment tree is next (pow of 2 for len)*2 - 1.
	 * 
	 * @param input
	 * @return
	 */
	public int[] createSegmentTree(int input[]) {

		int nextPowOfTwo = nextPowerOf2(input.length);
		int segmentTree[] = new int[nextPowOfTwo * 2 - 1];

		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}
		constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0);
		return segmentTree;
	}

	public int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	private void constructMinSegmentTree(int segmentTree[], int input[], int low, int high, int segTreePos) {
		if (low == high) {
			segmentTree[segTreePos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		
		constructMinSegmentTree(segmentTree, input, low, mid, 2 * segTreePos + 1);
		constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * segTreePos + 2);
		
		segmentTree[segTreePos] = Math.min(segmentTree[2 * segTreePos + 1], segmentTree[2 * segTreePos + 2]);
	}

	public int rangeMinimumQuery(int[] segmentTree, int qlow, int qhigh, int len) {
		return rangeMinimumQuery(segmentTree, 0, len - 1, qlow, qhigh, 0);
	}

	private int rangeMinimumQuery(int segmentTree[], int low, int high, int rlow, int rhigh, int pos) {
		//Total overlap. Return element at position. 
		if (rlow <= low && rhigh >= high) {
			return segmentTree[pos];
		}
		//No overlap. Return large value.
		if (rlow > high || rhigh < low) {
			return Integer.MAX_VALUE;
		}
		//Partial overlap. Navigate through children and return the minimum of both the children.
		int mid = (low + high) / 2;
		return Math.min(rangeMinimumQuery(segmentTree, low, mid, rlow, rhigh, 2 * pos + 1),
				rangeMinimumQuery(segmentTree, mid + 1, high, rlow, rhigh, 2 * pos + 2));
	}
}
