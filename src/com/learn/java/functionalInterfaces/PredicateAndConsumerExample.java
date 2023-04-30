package com.learn.java.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 5
public class PredicateAndConsumerExample {
	

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    Consumer<Student> studentConsumer = (student) -> {

        if(p1.and(p2).test(student)){
            studentBiConsumer.accept(student.getName(),student.getActivities());
        }
    };
	
    // 1	
    public void printNameandActivities(List<Student> studentList){

        studentList.forEach(studentConsumer);

    }

	public static void main(String[] args) {
		
        List<Student> studentList = StudentDataBase.getAllStudents();

        new PredicateAndConsumerExample().printNameandActivities(studentList);
	}

}

/*
Emily : [swimming, gymnastics, aerobics]
Dave : [swimming, gymnastics, soccer]
James : [swimming, basketball, baseball, football]
*/
