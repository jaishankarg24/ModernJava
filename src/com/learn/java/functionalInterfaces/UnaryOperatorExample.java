package com.learn.java.functionalInterfaces;

import java.util.function.UnaryOperator;

// 11
public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = (s)->s.concat("Default");

    public static void main(String[] args) {

        System.out.println(unaryOperator.apply("java8"));

    }

}
// java8Default