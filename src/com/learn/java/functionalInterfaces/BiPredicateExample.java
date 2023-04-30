package com.learn.java.functionalInterfaces;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 6
public class BiPredicateExample {

    static BiPredicate<Integer,Double> biPredicate = (gradeLevel, gpa) ->  gradeLevel>=3 && gpa >=3.9 ;

    static Consumer<Student> consumer = (student) -> {
            if(biPredicate.test(student.getGradeLevel(),student.getGpa())){
                System.out.println(student);
            }
    };

    public static  void filterStudents(){

        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(consumer);
    }

    public static void main(String[] args) {
        filterStudents();
    }

}
/*
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}
*/