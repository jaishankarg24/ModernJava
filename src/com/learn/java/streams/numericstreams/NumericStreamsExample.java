package com.learn.java.streams.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 1 
public class NumericStreamsExample {

	// Numeric Streams
	
    public static int sumOfNumbers(List<Integer> integerList){

        return  integerList.stream() // Stream<Integer>
                 .reduce(0,(x,y)->x+y); // unboxing to convert Integer to an int.

     }

     public static int sumOfNumbersIntStream(){

         return IntStream.rangeClosed(1,6)
                 .sum(); //saves the unboxing effort.

     }

     public static void main(String[] args) {

         List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);

         System.out.println("Sum of numbers are : " + sumOfNumbers(integerList));

         System.out.println("Sum of numbers using IntStream are : " + sumOfNumbersIntStream());
     }

}

/*
Sum of numbers are : 21
Sum of numbers using IntStream are : 21

Represents the primitive values in a Stream. 
• IntStream 
• LongStream 
• DoubleStream

Numeric Stream Ranges:
Int Stream: 
IntStream.range(1,50) -> Returns an IntStream of 49 elements from 1 
to 49.
IntStream.rangeClosed(1,50) -> Returns an IntStream of 50 elements from 1 to 50.
Long Stream: 
LongStream.range(1,50) -> Returns a LongStream of 49 elements from 1 to 49.
LongStream.rangeClosed(1,50) -> Returns a LongStream of 50 elements from 1 to 50.
DoubleStream: 
- It does not support the range ()and rangeClosed().


*/
