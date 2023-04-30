package com.learn.java.lambdas;

import java.util.function.Consumer;

// 4
public class LambdaVariable2 {

    static int value =4;

    public static void main(String[] args) {


        // int value =4; //effectively final
        Consumer<Integer> c1 = (i) -> {
            value=6; // allowed 
             System.out.println(i+value); // 8
        };
        //value =2;

        c1.accept(2);
    }

}
