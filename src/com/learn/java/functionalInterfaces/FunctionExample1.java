package com.learn.java.functionalInterfaces;

// 8
public class FunctionExample1 {

    public static String appendDefault(String input){

        return FunctionExample.addSomeString.apply(input);
    }

    public static void main(String[] args) {
    	String appendDefault = appendDefault("Hello");
    	System.out.println(appendDefault);
    }

}
// hellodefault
