package com.learn.java.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 13
public class SupplierExample {

	public static Supplier<Student> studentSupplier = () -> {
		return new Student("Adam", 2, 4.0, "male", Arrays.asList("swimming", "basketball", "volleyball"));
	};

	public static Supplier<List<Student>> studentsSupplier = () -> StudentDataBase.getAllStudents();

	public static void main(String[] args) {

		Student student = studentSupplier.get();

		System.out.println("Student is : " + student);

		System.out.println("Students are : " + studentsSupplier.get());
	}

}
/*
Student is : Student{name='Adam', gradeLevel=2, gpa=4.0, gender='male', activities=[swimming, basketball, volleyball]}
Students are : [Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}, Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}, Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}, Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}, Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]
*/