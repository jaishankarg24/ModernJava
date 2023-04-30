package com.learn.java.streams.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 4
public class NumericStreamBoxingUnboxingExample {

    public static List<Integer> boxing() {

        return IntStream.rangeClosed(1,25)
                .boxed() //Stream<Integer>
                //all the elements will be passed one by one to get to the result as the collection.
                .collect(Collectors.toList());

    }

    public static int unBoxing(List<Integer> integerList) {

       int sum =  integerList.stream()
                .mapToInt(Integer::intValue).sum();
       return sum;

    }

    public static void main(String[] args) {

        System.out.println("Converting PrimitiveStream to List : "+ boxing());

        List<Integer> integers = boxing();

        System.out.println("Sum using Unboding : "  + unBoxing(integers));

    }

}

/*
 Converting PrimitiveStream to List : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
Sum using Unboding : 325
*/
