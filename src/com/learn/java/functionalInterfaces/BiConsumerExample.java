package com.learn.java.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 2
public class BiConsumerExample {

	// 3
    public static void nameAndActivities(){

        BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

//        Consumer<String> stringConsumer = (name) -> System.out.println("name is  :" + name);

        List<Student> students = StudentDataBase.getAllStudents();

        students.forEach((s) -> studentBiConsumer.accept(s.getName(),s.getActivities()));
    }
    
	public static void main(String[] args) {
		
		// Consumer Interface does not return anything
		
		// 1
        BiConsumer<String, String> biConsumer = (a,b) -> {
            System.out.println(" a : "  +  a + " b : " + b );
        };
        biConsumer.accept("java7" , "java8");

        // 2
        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("Multiplication : " + (a * b));
        };

        BiConsumer<Integer, Integer> addition = (a,b) -> {
            System.out.println("Addition : " + (a + b));
        };

        BiConsumer<Integer, Integer> division = (a,b) -> {
            System.out.println("Division : "  + (a / b));
        };


        multiply.andThen(addition).andThen(division).accept(10,5);
        /*
            a : java7 b : java8
			Multiplication : 50
			Addition : 15
			Division : 2
         */
        
        nameAndActivities();
	}

}

/*
 a : java7 b : java8
 
Multiplication : 50
Addition : 15
Division : 2

Adam : [swimming, basketball, volleyball]
Jenny : [swimming, gymnastics, soccer]
Emily : [swimming, gymnastics, aerobics]
Dave : [swimming, gymnastics, soccer]
Sophia : [swimming, dancing, football]
James : [swimming, basketball, baseball, football]
*/
