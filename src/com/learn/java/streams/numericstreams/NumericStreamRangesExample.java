package com.learn.java.streams.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

// 2
public class NumericStreamRangesExample {

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1,50);
        System.out.println("Total number of elements : " + intStream.count());
        //intStream.forEach(System.out::print); // stream closed error
        IntStream.range(1,50).forEach(value -> System.out.print(value+","));
        System.out.println();
        IntStream.rangeClosed(1,50).forEach(value -> System.out.print(value+","));
        System.out.println();
        System.out.println("Total no of elements using rangeClosed :" +IntStream.rangeClosed(1,50).count());

        LongStream.rangeClosed(1,50).forEach(value -> System.out.print(value+","));

        //asDoubleStream
        System.out.println();
        LongStream.rangeClosed(1,50).asDoubleStream().forEach(value -> System.out.print(value+","));

    }

}
/*
Total number of elements : 49
1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,
1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
Total no of elements using rangeClosed :50
1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0,19.0,20.0,21.0,22.0,23.0,24.0,25.0,26.0,27.0,28.0,29.0,30.0,31.0,32.0,33.0,34.0,35.0,36.0,37.0,38.0,39.0,40.0,41.0,42.0,43.0,44.0,45.0,46.0,47.0,48.0,49.0,50.0,
*/