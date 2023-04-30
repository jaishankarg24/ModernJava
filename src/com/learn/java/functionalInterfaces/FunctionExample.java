package com.learn.java.functionalInterfaces;

import java.util.function.Function;

// 7
public class FunctionExample {

    static Function<String,String> upperCase =  (name) -> name.toUpperCase();

    static Function<String,String> addSomeString =  (name) -> name.toLowerCase().concat("default");

    static Function<String,Integer> strLength =  (name) -> name.length();
    
	public static void main(String[] args) {
        System.out.println("Result is : " + upperCase.apply("java8"));

        System.out.println("Result of andthen : " + upperCase.andThen(addSomeString).apply("java8"));

        System.out.println("Result of compose : " + upperCase.compose(addSomeString).apply("java8"));

        Function<String,String> abc = Function.identity();

        System.out.println(abc.apply("ABC"));
	}

}

//.compose() - will execute first
/*
Result is : JAVA8
Result of andthen : java8default
Result of compose : JAVA8DEFAULT
ABC
*/
