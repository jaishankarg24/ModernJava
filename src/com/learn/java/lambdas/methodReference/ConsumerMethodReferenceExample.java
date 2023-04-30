package com.learn.java.lambdas.methodReference;

import java.util.function.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 2
public class ConsumerMethodReferenceExample {

    /**
     * Class::instancemethod
     */
    static Consumer<Student>  c1= System.out::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
        StudentDataBase.getAllStudents().forEach(c3);
    }

}

/*
Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}

List of Activities are : [swimming, basketball, volleyball]
List of Activities are : [swimming, gymnastics, soccer]
List of Activities are : [swimming, gymnastics, aerobics]
List of Activities are : [swimming, gymnastics, soccer]
List of Activities are : [swimming, dancing, football]
List of Activities are : [swimming, basketball, baseball, football]

List of Activities are : [swimming, basketball, volleyball]
List of Activities are : [swimming, gymnastics, soccer]
List of Activities are : [swimming, gymnastics, aerobics]
List of Activities are : [swimming, gymnastics, soccer]
List of Activities are : [swimming, dancing, football]
List of Activities are : [swimming, basketball, baseball, football]
*/