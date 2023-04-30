package com.learn.java.streams.terminalstreams;

import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

public class StreamsJoiningExample {

    public static String joining(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining()); // appends all the strings to produce the output,
    }

    public static String joiningWithDelimiter(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    public static String joiningWithDelimiterWithPrefix(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-","[","]")); // Alt+enter
    }

    public static void main(String[] args) {

        System.out.println("Names : "+ joining());
        System.out.println("Names With Delimiter : "+ joiningWithDelimiter());
        System.out.println("Names With Delimiter Prefix and Suffix : "+ joiningWithDelimiterWithPrefix());
    }

}

/*
• The collect() method takes in an input of type Collector. 
• Produces the result as per the input passed to the collect() 
method

• joining() Collector performs the String concatenation on the 
elements in the stream. 
• joining() has three different overloaded versions.

Names : AdamJennyEmilyDaveSophiaJames
Names With Delimiter : Adam-Jenny-Emily-Dave-Sophia-James
Names With Delimiter Prefix and Suffix : [Adam-Jenny-Emily-Dave-Sophia-James]
*/