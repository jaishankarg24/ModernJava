package com.learn.java.streams.numericstreams;

import java.util.stream.IntStream;

// 6
public class NumericStreamAsExample {

    public static double asDoubleStream(){

    return  IntStream.rangeClosed(1,5)
                .asDoubleStream()
                .sum();
    }


    public static long asLongStream(){
        return  IntStream.rangeClosed(1,5)
                .asLongStream()
                .sum();

    }

    public static void main(String[] args) {

        System.out.println("asDoubleStream :" + asDoubleStream());
        System.out.println("asLongStream :" + asLongStream());

    }

}

/*
asDoubleStream :15.0
asLongStream :15
*/