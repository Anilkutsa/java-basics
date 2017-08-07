package com.java_concepts.datastructures;

import java.util.*;

public class Stack {

	public static void main(String[] args) {
		Stack s = new Stack();
		// s.nextGretestElement();
		//s.initStackSort();
		s.initReverseStack();
	}

	void printStack(Deque<Integer> stack) {
		System.out.println("Printing elements of the stack...");
		Iterator itr = stack.descendingIterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
	
	void initReverseStack(){
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(5);
		stack.push(2);
		stack.push(20);
		stack.push(12);
		stack.push(9);
		stack.push(11);
		printStack(stack);
		System.out.println("\nReversing the stack... ");
		reverseStack(stack);
		printStack(stack);
	}
	
	void reverseStack(Deque<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int pop1 = stack.pop();
		reverseStack(stack);
		reverseStackInsert(stack, pop1);
	}
	
	void reverseStackInsert(Deque<Integer> stack, int x){
		if(stack.isEmpty()){
			stack.push(x);
			return;
		}
		int pop2 = stack.pop();
		reverseStackInsert(stack, x);
		stack.push(pop2);
	}
	
	/**
	 * Sorting stack happens in two recursive calls
	 * First empty the stack elements in call stack
	 * Insert one after one and each insert compare 
	 * @param stack
	 */
	
	void initStackSort() {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(5);
		stack.push(2);
		stack.push(20);
		stack.push(12);
		stack.push(9);
		stack.push(11);
		printStack(stack);
		System.out.println("\nSorting the stack... ");
		sortStack(stack);
		printStack(stack);
	}

	void sortStack(Deque<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int pop1 = stack.pop();
		sortStack(stack);
		sortedInsert(stack, pop1);
	}
	
	void sortedInsert(Deque<Integer> stack, int x){
		if(stack.isEmpty() || x > stack.peek()){
			stack.push(x);
			return;
		}
		int pop2 = stack.pop();
		sortedInsert(stack, x);
		stack.push(pop2);
	}

	void nextGreatestElement() {

		int[] array = { 2, 6, 4, 9, 3 };
		int stackPopEle, arrayNext;
		Deque<Integer> tempStack = new ArrayDeque<>();

		// Push first array element into stack
		tempStack.push(array[0]);

		/**
		 * Start checking from 1st position of array 
		 * Keep popping and comparing till the popped element is less than array element
		 * 
		 * Pop all the elements which are less than current array element
		 * 
		 * Finally, we will be pushing elements back to stack in two scenarios -
		 * 1. If the elements is less than current array Element 2. The current
		 * array element itself
		 */
		for (int i = 1; i < array.length; i++) {
			arrayNext = array[i];

			if (!tempStack.isEmpty()) {

				/**
				 * Popped element can either be less or greater than current
				 * array element If less, pop it and print current array element
				 * else, add it back to stack
				 */

				stackPopEle = tempStack.pop();

				while (stackPopEle < arrayNext) {
					System.out.println("Next greater element for " + stackPopEle + " is " + arrayNext);
					if (tempStack.isEmpty()) {
						break;
					}
					stackPopEle = tempStack.pop();
				}

				if (stackPopEle > arrayNext)
					tempStack.push(stackPopEle);
			}

			tempStack.push(arrayNext);
		}

		/**
		 * After the entire iteration, there may still be elements left over in
		 * the stack Either because, there was no larger element on its right or
		 * because, the element is the right most element in the array In this
		 * case, print the next higher element as -1
		 */

		while (!tempStack.isEmpty()) {
			stackPopEle = tempStack.pop();
			arrayNext = -1;
			System.out.println("Next greater element for " + stackPopEle + " is " + arrayNext);
		}
	}
}
