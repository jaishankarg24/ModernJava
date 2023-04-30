package com.learn.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 5
public class StreamsComparatorExample {

    public static List<Student> sortStudentsByName(){

        return  StudentDataBase.getAllStudents().stream()
                 .sorted(Comparator.comparing(Student::getName))
                 .collect(Collectors.toList());
     }

     public static List<Student> sortStudentsByGpa(){

         return  StudentDataBase.getAllStudents().stream()
                 .sorted(Comparator.comparing(Student::getGpa)) // ascending order
                 .collect(Collectors.toList());
     }

     public static List<Student> sortStudentsByGpaReversed(){

         return  StudentDataBase.getAllStudents().stream()
                 .sorted(Comparator.comparing(Student::getGpa).reversed()) // descending order
                 .collect(Collectors.toList());
     }

     public static void main(String[] args) {
         System.out.println("Students sorted by NAME");
         sortStudentsByName().forEach(System.out::println);
         System.out.println("Students sorted by GPA");
          sortStudentsByGpa().forEach(System.out::println);

         System.out.println("Students sorted by GPA Higher to Lower");
         sortStudentsByGpaReversed().forEach(System.out::println);

     }

}
/*
Students sorted by NAME
Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}
Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}

Students sorted by GPA
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}

Students sorted by GPA Higher to Lower
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}
Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
*/
