package com.learn.java.streams;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 13
public class StreamsOfGenerateIterateExample {

    public static void main(String[] args) {

    	// Factory methods
        Stream<String> stringStream = Stream.of("adam","dan","jenny","dave");
        stringStream.forEach(System.out::println);

        List<Integer> integerList  = Stream.iterate(1, x->x*2)
                .limit(10)
                .map(Integer::new)
                .collect(Collectors.toList());

        System.out.println("iterate : " + integerList);


        Supplier<Integer> supplier = new Random()::nextInt;

        List<Integer> integerList1  = Stream.generate(supplier)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("generate : " + integerList1);

    }

}
/*
• Of() -> Creates a stream of certain values passed to this method.( of type)
 iterate(), generate() -> Used to create infinite Streams.
 
 adam
dan
jenny
dave
iterate : [1, 2, 4, 8, 16, 32, 64, 128, 256, 512]
generate : [476309440, -660352946, -2111034801, -62718884, -1390049260, -721379339, 1775222909, 1958257358, -293365346, 1489518398]
*/
