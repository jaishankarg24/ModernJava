package com.learn.java.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 6
public class StreamsFilterExample {
	
	// • filter – filters the elements in the stream. 
	// Input to the filter is a Predicate Functional Interface

    public static List<Student> filterStudents(){

        List<Student> filteredStudentList = StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .filter(student -> student.getGender().equals("female"))
                .collect(Collectors.toList());

        return filteredStudentList;
    }

    public static void main(String[] args) {

        System.out.println("Filtered Students : " + filterStudents());

    }

}
