package com.learn.java.streams.terminalstreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 4
public class StreamsMinByMaxByExample {

    public static Optional<Student> minBy(){

        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

        return studentOptional;
    }

    public static Optional<Student> maxBy(){

        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        return studentOptional;
    }

        public static  List<Student>  maxByMultipleStudents(){

            List<Student> maxStudents = new ArrayList<>();
            Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                    .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

            Student maxStudent = studentOptional.isPresent() ? studentOptional.get() : null ;
            if(maxStudent!=null){

                maxStudents = StudentDataBase.getAllStudents().stream()
                        .filter(student -> maxStudent.getGpa() == student.getGpa())
                        .collect(Collectors.toList());

                System.out.println("Max Students are : " + maxStudents);
            }
            return maxStudents;
        }


    public static void main(String[] args) {

        System.out.println(minBy());

        System.out.println(maxBy());

        System.out.println(maxByMultipleStudents());
    }

}

/*
 * • Comparator as an input parameter and Optional as an output. 
• maxBy() 
• This collector is used in conjunction with comparator. Returns the max 
element based on the property passed to the comparator. 
• minBy() 
• This collector is used in conjunction with comparator. Returns the 
smallest element based on the property passed to the comparator.

Optional[Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}]
Optional[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}]
Max Students are : [Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}]
[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}]
*/
