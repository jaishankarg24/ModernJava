package com.learn.java.streams.terminalstreams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 3
public class StreamsMappingExample {

    public static void main(String[] args) {

        Set<String> namesSet = StudentDataBase.getAllStudents()
                 .stream()
                 .collect(mapping(Student::getName, Collectors.toSet())); // this avoids the additional map intermediate operation.

         System.out.println("namesSet : " + namesSet);

         List<String> namesList = StudentDataBase.getAllStudents()
                 .stream()
                 .collect(mapping(Student::getName, Collectors.toList())); // this avoids the additional map intermediate operation.

         System.out.println("namesList : " + namesList);

     }
}
/*
• mapping() collector applies a transformation function first and 
then collects the data in a collection( could be any type of 
collection)

namesSet : [Adam, Emily, James, Jenny, Dave, Sophia]
namesList : [Adam, Jenny, Emily, Dave, Sophia, James]
*/