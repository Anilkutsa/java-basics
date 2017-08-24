package com.java_concepts.strings_arrays;

import java.util.*;

/**
 * 
 * @author anil
 *
 *         Given a collection of intervals, merge all overlapping intervals. For
 *         example, Given [1,3],[2,6],[8,10],[15,18], return
 *         [1,6],[8,10],[15,18].
 *         
 *         Solution -
 *         1. Sort the elements first
 *         2. Compare if first element of next element is less than prev last element
 *         3. If yes, continue the loop through next elements till above condition is true
 *         4. If not, quit and save the interval
 * 
 */

public class MergeOverlappingIntervals {

	List<Interval> list;

	MergeOverlappingIntervals() {
		list = new ArrayList<>();
	}

	class Interval {
		int start;
		int end;

		Interval(int first, int last) {
			this.start = first;
			this.end = last;
		}
	}

	class IntervalComparator implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			Interval i1 = (Interval) o1;
			Interval i2 = (Interval) o2;
			return i1.start - i2.start;
		}
	}

	public static void main(String[] args) {
		new MergeOverlappingIntervals().init();
	}

	private void init() {
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(9, 13));
		list.add(new Interval(15, 18));

		List<Interval> mergedList = merge(list);
		for (Interval i : mergedList) {
			System.out.print("{" + i.start + "," + i.end + "}");
		}
	}

	private List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedList = new ArrayList<>();

		if (intervals.size() == 0)
			return intervals;
		if (intervals.size() == 1)
			return intervals;

		Collections.sort(intervals, new IntervalComparator());

		Interval first = list.get(0);
		int start = first.start;
		int end = first.end;

		for (int i = 1; i < intervals.size(); i++) {
			Interval current = list.get(i);
			if (current.start <= end) {
				end = Math.max(current.end, end);
			} else {
				mergedList.add(new Interval(start, end));
				start = current.start;
				end = current.end;
			}
		}
		mergedList.add(new Interval(start, end));
		return mergedList;
	}

}
