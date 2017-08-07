package com.java_concepts.datastructures;

import java.util.*;

public class Queues {

	public static void main(String[] args) {
		Queues q = new Queues();
		q.testQueue();
	}

	void testQueue() {
		Deque<Integer> queue = new ArrayDeque<Integer>();

		queue.addFirst(2);
		queue.addFirst(6);
		queue.addFirst(3);
		queue.addFirst(8);
		queue.addFirst(10);
		queue.addFirst(12);
		queue.addFirst(22);

		printQueue(queue);
		
		queue.removeLast();
		queue.removeLast();
		
		System.out.println("\nAfter popping elements");
		printQueue(queue);
		
		System.out.println("\nPeeking elements " +  queue.peekLast() );
		
	}

	void printQueue(Deque<Integer> queue) {
		Iterator itr = queue.descendingIterator();
		
		while(itr.hasNext()){
			System.out.print(itr.next() + " ");
		}
	}

}
