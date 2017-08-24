package com.java_concepts.strings_arrays;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
		new PostfixEvaluation().init();
	}

	private void init() {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evaluateExpression(tokens));
	}

	private String evaluateExpression(String[] tokens) {
		int result = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();

		for (String i : tokens) {
			if (!operators.contains(i)) {
				stack.push(i);
			} else {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				switch (i) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(a - b));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(a / b));
					break;
				}
			}
		}
		return stack.pop();
	}
}
