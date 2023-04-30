package com.learn.java.lambdas;

// 2
public class RunnableLambdaExample {

	public static void main(String[] args) {
		/**
		 * Prior Java 8
		 */

		// 1
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable 1");
			}
		};

		new Thread(runnable).start();

		// Java 8 - Lambda Syntax

		// ()->{}
		// assigning a lambda to a variable.

		// 2
		Runnable runnableLambda = () -> {
			System.out.println("Inside Runnable 2");
		};

		new Thread(runnableLambda).start();

		// 3
		Runnable runnableLambdaSimple = () -> System.out.println("Inside Runnable 3");

		new Thread(runnableLambdaSimple).start();

		// 4
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable 3");
			}
		}).start();

		// 5
		Runnable runnableLambdaMultiStatements = () -> {
			System.out.println("Inside Runnable 3");
			System.out.println("Inside Runnable 3");
		};

		new Thread(runnableLambdaMultiStatements).start();
		
		/*Inside Runnable 1
		Inside Runnable 2
		Inside Runnable 3
		Inside Runnable 3
		Inside Runnable 3
		Inside Runnable 3
		*/

	}

}
