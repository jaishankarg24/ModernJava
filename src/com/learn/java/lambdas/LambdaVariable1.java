package com.learn.java.lambdas;

import java.util.function.Consumer;

// 3
public class LambdaVariable1 {

	public static void main(String[] args) {
		
        int i=2; //Repeated varibale name not allowed
        
        //Consumer<Integer> c1 = (i) -> {   (i) not allowed
        Consumer<Integer> c1 = (a) -> {
            //int i=2;// Lambda expression's local variable i cannot redeclare another local variable defined in an enclosing scope. 
            System.out.println(i*a); // 4
        };
        
        c1.accept(2);

	}

}
