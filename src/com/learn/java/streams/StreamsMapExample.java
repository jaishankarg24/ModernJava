package com.learn.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 3
public class StreamsMapExample {

	// map : Convert(transform) one type to another.
    private static List<String> namesUpperCase(List<Student> names){
        List<String> namesUpperCase = names.stream() //Stream<Student>
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) // Stream<String> -> UpperCase
                .collect(Collectors.toList()); // returns List // terminal operation
        return namesUpperCase;
    }

    private static Set<String> namesSetUpperCase(List<Student> students){
        Set<String> namesUpperCase = students.stream() //Stream<Student>
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) // Stream<String> -> UpperCase
                .collect(Collectors.toSet()); // returns List // terminal operation
        return namesUpperCase;
    }

    private static Map<String, Integer>  namesLengthMap(ArrayList<String> names){

        Map<String, Integer> namesLengthMap = names.stream()//Stream<String>
                .collect(Collectors.toMap(String::toString,String::length)); // returns Map

        return namesLengthMap;
    }


    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("dan");
        names.add("jenny");

        System.out.println("namesUpperCase List : " + namesUpperCase(StudentDataBase.getAllStudents()));
        System.out.println("namesUpperCase Set : " + namesSetUpperCase(StudentDataBase.getAllStudents()));
        System.out.println("namesLengthMap : " + namesLengthMap(names));

    }

}
/*
namesUpperCase List : [ADAM, JENNY, EMILY, DAVE, SOPHIA, JAMES]
namesUpperCase Set : [ADAM, DAVE, JAMES, SOPHIA, JENNY, EMILY]
namesLengthMap : {dan=3, adam=4, jenny=5}
*/