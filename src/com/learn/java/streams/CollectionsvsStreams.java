package com.learn.java.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

// 2
public class CollectionsvsStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        for (String name: names) {
        	System.out.println(name);
        }
        

        for (String name: names) {
        	System.out.println(name);
        }
        Stream<String> namesStream = names.stream();

        namesStream.forEach(System.out::println);
        //namesStream.forEach(System.out::println);

    }

}
//Adam
//Jim
//Jenny

//Adam
//Jim
//Jenny
//Adam
//Jim
//Jenny
//Adam
//Jim
//Jenny
