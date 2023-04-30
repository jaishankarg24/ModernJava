package com.learn.java.streams.parallelstreams;

import java.util.stream.IntStream;

// 5
public class SumClient {
 // when not to use parallelStream
    public static void main(String[] args) {

        Sum sum=new Sum();

        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::performSum); //result is : 500500

        System.out.println(sum.getTotal());
    }

}
// 500500
// 180904
// 500092
// 470386