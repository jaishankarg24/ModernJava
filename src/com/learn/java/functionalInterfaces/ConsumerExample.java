package com.learn.java.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 1
public class ConsumerExample {

	static Consumer<Student>  c2 = (student) -> System.out.println(student);
	
	static Consumer<Student>  c3 = p -> System.out.print(p.getName().toUpperCase());

	static Consumer<Student>  c4 = p -> System.out.println(p.getActivities());
	
	// 2
    public static void printName(){

    	// Consumer<Student>  c2 = (student) -> System.out.println(student);
    	
        List<Student> personList = StudentDataBase.getAllStudents();

        personList.forEach(c2);

    }
    
    // 3
    public static void printNameAndActivities(){
    	
    	// To avoid duplicates
         // Consumer<Student>  c3 = p -> System.out.print(p.getName().toUpperCase());

         // Consumer<Student>  c4 = p -> System.out.println(p.getActivities());
        
        System.out.println("printNameAndActivities : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(c3.andThen(c4)); // consumer chaning
    }
    
    // 4
    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition : ");
        
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach((s) -> {
            if( s.getGradeLevel() >= 3 && s.getGpa() > 3.9){
                c3.andThen(c4).andThen(c2).accept(s);
            }
        });
    }
    
	public static void main(String[] args) {

		// 1 accept(), andThen()
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase()); // JAVA8

        c1.accept("java8");
        
        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
	}

}
/*
 printName();
 
Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}
Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}
Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}


printNameAndActivities : 
ADAM[swimming, basketball, volleyball]
JENNY[swimming, gymnastics, soccer]
EMILY[swimming, gymnastics, aerobics]
DAVE[swimming, gymnastics, soccer]
SOPHIA[swimming, dancing, football]
JAMES[swimming, basketball, baseball, football]


printNameAndActivitiesUsingCondition : 
EMILY[swimming, gymnastics, aerobics]
DAVE[swimming, gymnastics, soccer]


printNameAndActivitiesUsingCondition : 
EMILY[swimming, gymnastics, aerobics]
Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}
DAVE[swimming, gymnastics, soccer]
Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}
*/