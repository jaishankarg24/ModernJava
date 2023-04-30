package com.learn.java.streams;

import java.util.Optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 12
public class StreamsFindAnyFirstExample {

    public static Optional<Student> findAny(){

        return StudentDataBase.getAllStudents().parallelStream()
                .filter(student -> student.getGpa()>=3.8)
                .findAny();
    }

    public static Optional<Student> findFirst(){

        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.8)
                .findFirst();
    }

    public static void main(String[] args) {

        Optional<Student> findAnyStudent = findAny();
        if(findAnyStudent.isPresent()){
            System.out.println("Student is :" + findAnyStudent.get());
        }else{
            System.out.println("No Student Found");
        }

        Optional<Student> findFirst = findFirst();
        if(findFirst.isPresent()){
            System.out.println("Student is :" + findFirst.get());
        }else{
            System.out.println("No Student Found");
        }
        //it will make a lot of different during parallel stream

    }

}
/*
Used to find an element in the stream. 
• Both the functions returns the result of type Optional. 
• findFirst() – Returns first element in the stream. 
• findAny() – Returns the first encountered element in the 
stream.


Student is :Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
Student is :Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}

StudentDataBase.getAllStudents().parallelStream()
Student is :Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student is :Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}

short circuiting
&& false -> false
|| true -> true
*/