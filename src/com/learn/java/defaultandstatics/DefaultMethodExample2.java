package com.learn.java.defaultandstatics;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 2
public class DefaultMethodExample2 {

    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparing(Student::getGpa);
    static Comparator<Student> genderComparator = Comparator.comparing(Student::getGender);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);
    static Consumer<Student> studentConsumer = student -> System.out.println("student : " + student);

    public static void sortByName(List<Student> studentList){

        studentList.sort(Comparator.comparing(Student::getName)); // inline
        studentList.sort(nameComparator); // Using a reference
        System.out.println("After Sort BY Name : ");
        studentList.forEach(studentConsumer);
    }

    public static void sortByGPA(List<Student> studentList){

        studentList.sort(gpaComparator);
        System.out.println("After Sort BY GPA : ");
        studentList.forEach(studentConsumer);
    }

    public static void sortByGender(){

        List<Student> studentList = StudentDataBase.getAllStudents();
        Comparator<Student> nullLast = Comparator.nullsFirst(genderComparator);
        studentList.sort(nullLast);
        System.out.println("After Sort By Gender : ");
        studentList.forEach(studentConsumer);

    }


    public static void comparatorChaining(){

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        System.out.println("Comparator Chaining List");
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Original List");
        studentList.forEach(student -> System.out.println("student : " + student));
        /*sortByGender();
        sortByName(studentList);
        sortByGPA(studentList);*/
        comparatorChaining();
        sortWithNullValues(studentList);

    }

	private static void sortWithNullValues(List<Student> studentList) {
		Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
		// Comparator<Student> studentComparator = Comparator.nullsLast(nameComparator);
		studentList.sort(studentComparator);
		studentList.forEach(studentConsumer);
		
	}

}

/*
Original List
student : Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
student : Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
student : Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
student : Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
student : Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
student : Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}
Comparator Chaining List
student : Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
student : Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
student : Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
student : Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
student : Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}
student : Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
*/
