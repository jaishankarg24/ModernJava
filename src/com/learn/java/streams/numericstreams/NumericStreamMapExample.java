package com.learn.java.streams.numericstreams;

import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

// 5
public class NumericStreamMapExample {

    public static List<Integer> mapToObj(){

        List<Integer> integerList = IntStream.rangeClosed(1,5)
                .mapToObj((i)-> {
                    return new Integer(i);
                })
                .collect(toList());

        return integerList;

    }

    public static double mapToDouble(){

      return   IntStream.rangeClosed(1,5)
                .mapToDouble((i) ->  i)
                .sum();

    }

    public static long mapToLong(){

        return   IntStream.rangeClosed(1,5)
                .mapToLong((i) ->  i)
                .sum();

    }

    public static void main(String[] args) {

        System.out.println("mapToObj : " + mapToObj());

        System.out.println("mapToDouble() : " + mapToDouble());

        System.out.println("mapToLong() : " + mapToLong());

    }

}

/*
 mapToObj : [1, 2, 3, 4, 5]
mapToDouble() : 15.0
mapToLong() : 15

• mapToObj –> Convert a each element numeric stream to some 
Object. 
• mapToLong –> Convert a numeric stream to a Long Stream. 
• mapToDouble –> Convert a numeric stream to a Double 
Stream.

*/
