package com.learn.java.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 4
public class StreamFlatMapExample {

	// • flatMap : Converts(Transforms) one type to another as like map() method
    public static List<String> printStudentActivities() {

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(Collectors.toList());

        return studentActivities;

    }

    public static List<String> printUniqueStudentActivities() {

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return studentActivities;

    }

    public static long getStudentActivitiesCount() {

        long totalActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        return totalActivities;

    }

    public static void main(String[] args) {


        System.out.println("Student Activities : " + printStudentActivities());
        System.out.println("Unique Student Activities : " + printUniqueStudentActivities());
        System.out.println("Unique Student Activities Count: " + getStudentActivitiesCount());

    }

}
/*
Student Activities : [swimming, basketball, volleyball, swimming, gymnastics, soccer, swimming, gymnastics, aerobics, swimming, gymnastics, soccer, swimming, dancing, football, swimming, basketball, baseball, football]
Unique Student Activities : [aerobics, baseball, basketball, dancing, football, gymnastics, soccer, swimming, volleyball]
Unique Student Activities Count: 9
*/
