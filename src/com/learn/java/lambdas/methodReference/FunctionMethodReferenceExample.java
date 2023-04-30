package com.learn.java.lambdas.methodReference;

import java.util.function.Function;

// 1
public class FunctionMethodReferenceExample {

    /**
     * Class::instancemethod
     */
    static Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase(); // ctrl+1 to convert

    static Function<String,String> toUpperCaseMethodRefernce = String::toUpperCase;

    public static void main(String[] args) {

        System.out.println(toUpperCaseLambda.apply("java8"));

        System.out.println(toUpperCaseMethodRefernce.apply("java8"));


    }

}
//JAVA8
//JAVA8