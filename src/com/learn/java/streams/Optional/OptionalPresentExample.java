package com.learn.java.streams.Optional;

import java.util.Optional;

// 5
public class OptionalPresentExample {

    public static void main(String[] args) {

        Optional<String> stringOptional = Optional.ofNullable("Hello Optional");

        System.out.println(stringOptional.isPresent());

        stringOptional.ifPresent((s -> System.out.println("value is : " + s)));
    }

}

/*
true
value is : Hello Optional

null
false
*/