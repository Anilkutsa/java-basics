package com.java_concepts.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	public static void main(String... args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();

		System.out.println("submitted callable task to calculate factorial of 10");
		Future result10 = es.submit(new FactorialCalculator(10));

		System.out.println("Calling get method of Future to fetch result of factorial 10");
		long factorialof10 = (long) result10.get();
		System.out.println("factorial of 10 is : " + factorialof10);
	}

}
