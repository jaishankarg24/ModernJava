package com.learn.java.streams.terminalstreams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 7
public class StreamsPartitioningExample {

    public static void partitioningBy_1(){

        Predicate<Student> gpaPredicate = (student) -> student.getGpa()>=3.8;

        Map<Boolean,List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate));

        System.out.println("studentMap : " + studentMap);

    }

    public static void partitioningBy_2(){

        Predicate<Student> gpaPredicate = (student) -> student.getGpa()>=3.8;

        Map<Boolean,Set<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));

        System.out.println("studentMap : " + studentMap);

    }


    public static void partitioningBy_3(){

        Predicate<Student> gpaPredicate = (student) -> student.getGpa()>=3.8;

        Map<Boolean,Map<String, List<String>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect( Collectors.partitioningBy(gpaPredicate, Collectors.toMap(Student::getName,Student::getActivities)));

        System.out.println("studentMap : " + studentMap);

    }

    public static void main(String[] args) {
        partitioningBy_1();
        partitioningBy_2();
        partitioningBy_3();
    }

}

/*
 * • partitioningBy() collector is also a kind of groupingBy(). 
• paritioningBy() accepts a predicate as an input. 
• Return type of the collector is going to be Map<K,V> 
• The key of the return type is going to be a Boolean. 
• There are two different versions of partitioningBy() 
• partitioningBy(predicate) 
• partitioningBy(predicate,downstream) // downstream -> could be of any 
collector

studentMap : {false=[Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}, Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}], true=[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}, Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}, Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}
studentMap : {false=[Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}, Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}], true=[Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}, Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}]}
studentMap : {false={Adam=[swimming, basketball, volleyball], Sophia=[swimming, dancing, football]}, true={Emily=[swimming, gymnastics, aerobics], James=[swimming, basketball, baseball, football], Dave=[swimming, gymnastics, soccer], Jenny=[swimming, gymnastics, soccer]}}

*/
