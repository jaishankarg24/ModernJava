package com.learn.java.streams.Optional;

import java.util.Optional;

// 2
public class OptionalOfEmptyNullableExample {


    public static Optional<String> ofNullable(){

       return  Optional.ofNullable("Hello");

    }

    public static Optional<String> of(){

        return  Optional.of("Hello");
       // return  Optional.of(null);

    }

    public static Optional<String> empty(){

        return  Optional.empty();
        // return  Optional.of(null);

    }
    public static void main(String[] args) {

        System.out.println(ofNullable().get());
        System.out.println(of().get());
        System.out.println(empty().isPresent()); //false
    }

}
/*
Hello
Optional[Hello]
Exception in thread "main" java.util.NoSuchElementException: No value present
*/