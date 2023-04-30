package com.learn.java.streams;

import com.learn.java.data.StudentDataBase;

// 11
public class StreamsMatchExample {

    public static boolean allMatch(){

        boolean result = StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.9);

        return result;
    }

    public static boolean anyMatch(){

        boolean result = StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=3.9);

        return result;
    }

    public static boolean noneMatch(){

        boolean result = StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=3.9);

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Result of allMatch : " + allMatch());
        System.out.println("Result of anyMatch : " + anyMatch());
        System.out.println("Result of noneMatch : " + noneMatch());
    }

}

/*
 * • All these functions takes in a predicate as an input and returns 
a Boolean as an output. 
• anyMatch()- Returns true if any one of the element matches the 
predicate, otherwise false. 
• allMatch() - Returns true if all the element in the stream matches the 
predicate, otherwise false. 
• noneMatch() – Just opposite to allMatch(). Returns true if none of the 
element in the stream matches the predicate, otherwise false.

Result of allMatch : false
Result of anyMatch : true
Result of noneMatch : false
*/
