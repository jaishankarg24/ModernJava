package com.learn.java.streams.Optional;

import java.util.Optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 1
public class OptionalExample {

    public static String getStudentName(){

         Student student = StudentDataBase.studentSupplier.get();
         // Student student = null;
         if(student!=null){
             return  student.getName();
         }else{
             return  null;
         }
     }

     public static Optional<String> getStudentNameOptional(){

         Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
         //Optional<Student> student = Optional.ofNullable(null); // Optional.empty();

         if(student.isPresent()){
        	 student.get(); //Student
             return  student.map(Student::getName); // don't get confused this with streams map method. Both are different.
         }
         return Optional.empty();
     }

     public static void main(String[] args) {
    	 System.out.println(getStudentName());

         if(getStudentNameOptional().isPresent()){
             System.out.println(getStudentNameOptional().get());
         }else{
             System.out.println("Name is returned as empty.");
         }


     }

}

/*
• Introduced as part of Java 8 to represent a Non-Null value 
• Avoids Null Pointer Exception and Unnecessary Null Checks. 
• Inspired from the new languages such as scala , groovy etc.,

Adam

*/