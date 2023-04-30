package com.learn.java.functionalInterfaces;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 4
public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;

    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
    
    
//    static Function<Integer,Predicate<Integer>> gradePredicate = (toCompare) -> (number) -> number > toCompare;
//    static Function<Double,Predicate<Double>>  gpaPredicate = (toCompare) -> (number) -> number > toCompare;

    static void filterStudentByGradeLevel() {
    	List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        }));
    }
    
	private static void filterStudentByGpl() {
    	List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        }));
	}
    
	private static void filterStudentByBoth() {
		System.out.println("filterStudentByBoth==================");
    	List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if(p1.and(p2).test(student)){
                System.out.println(student);
            }
            // p1.or(p2).negate().test(student)
        }));
		
	}
	
	public static void main(String[] args) {
		
        List<Student> studentList = StudentDataBase.getAllStudents();

//        studentList.stream()
//                .filter(PredicateStudentExample.p1)
//                .collect(Collectors.toList());

        // 1
        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        }));	

        // 2
        filterStudentByGradeLevel();
        
        // 3
        filterStudentByGpl();
        
        // 4
        filterStudentByBoth();
        
        // 5
//        boolean result = gradePredicate.apply(2).test(5) && gpaPredicate.apply(3.6).test(3.9);
//        System.out.println("Result from Predicate : " + result);
	}



}

/*
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}

filterStudentByBoth==================
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}

*/