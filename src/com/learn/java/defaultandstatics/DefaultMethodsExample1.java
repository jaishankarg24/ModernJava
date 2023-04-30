package com.learn.java.defaultandstatics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1
public class DefaultMethodsExample1 {

	public static void main(String[] args) {
        List<String> stringList  = Arrays.asList("Adam", "Jenny", "Alex","Eric","Mike");

        Collections.sort(stringList);
        System.out.println("Sorted list : " +  stringList);
       

        stringList.sort(Comparator.naturalOrder());

        System.out.println("Sorted list : " +  stringList);

        stringList.sort(Comparator.reverseOrder());

        System.out.println("Reverse Sorted list : " +  stringList);
	}

}

/*
Sorted list : [Adam, Alex, Eric, Jenny, Mike]
Sorted list : [Adam, Alex, Eric, Jenny, Mike]
Reverse Sorted list : [Mike, Jenny, Eric, Alex, Adam]

Interface can have default method and method implementation
static method can't be overridden
*/