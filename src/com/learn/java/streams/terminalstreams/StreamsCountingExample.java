package com.learn.java.streams.terminalstreams;

import java.util.stream.Collectors;

import com.learn.java.data.StudentDataBase;

// 2
public class StreamsCountingExample {

    public static long count(){
        return  StudentDataBase.getAllStudents()
                 .stream()
                 .filter(student -> student.getGpa()>=3.9)
                 .collect(Collectors.counting());
     }

     public static void main(String[] args) {

         System.out.println(count());
     }

}

/*
3

counting() Collector returns the total number of elements as a 
result. returns type long
*/