package com.learn.java.streams.terminalstreams;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 6
public class StreamsGroupingByExample {

    public static void groupingByGender(){

        Map<String,List<Student>> studentMap =  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

        Stream.of(studentMap).forEach(System.out::println);
    }

    public  static void customizedGroupingBy(){

        Map<String,List<Student>> studentMap =  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa()>= 3.8 ?  "OUTSTANDING" : "AVERAGE"));

        Stream.of(studentMap).forEach(System.out::println);
    }

    /**
     * Grouping by Two parameters
     */
    public  static void twoLevelGrouping(){

        Map<Integer,  Map<String,List<Student>>> studentMap =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                		Collectors.groupingBy(student -> student.getGpa()>= 3.8 ?  "OUTSTANDING" : "AVERAGE")));

        Stream.of(studentMap).forEach(System.out::println);

    }

    /**
     * Grouping by Two parameters
     */
    public  static void twoLevelGrouping_2(){

        Map<String,Integer> nameNoteBooksMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName,
                		Collectors.summingInt(Student::getNoteBooks)));// second argument can be of any type of collector

        System.out.println(nameNoteBooksMap);
    }

    /**
     * Grouping by Two parameters
     */
    public  static void twoLevelGrouping_3(){

        Map<String,Set<Student>> nameNoteBooksMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName,
                		Collectors.toSet()));// second argument can be of any type of collector

        System.out.println(nameNoteBooksMap);
    }


    public static void threeArgumentGroupingBy(){

        LinkedHashMap<String,Set<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName,LinkedHashMap::new,
                        Collectors.toSet()));

        System.out.println(" studentMap : " + studentMap);
    }


    public  static void calculteTopGpaStudentinEachGrade(){

        Map<Integer, Optional<Student>> studentMapOptional =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparingDouble(Student::getGpa))
                ));

        Stream.of(studentMapOptional).forEach(System.out::println);


        Map<Integer, Student> studentMap =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                		Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student::getGpa))
                        ,Optional::get
                )));

        Stream.of(studentMap).forEach(System.out::println);
    }

    public  static void calculteleastGpaStudentinEachGrade(){

        Map<Integer, Optional<Student>> studentMapOptional =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.minBy(Comparator.comparingDouble(Student::getGpa))
                ));

        Stream.of(studentMapOptional).forEach(System.out::println);


        Map<Integer, Student> studentMap =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                		Collectors.collectingAndThen( Collectors.minBy(Comparator.comparingDouble(Student::getGpa))
                                ,Optional::get
                        )));

        Stream.of(studentMap).forEach(System.out::println);
    }

    public static void main(String[] args) {

        //groupingByGender();
        //groupByGrade();
        twoLevelGrouping();
        //twoLevelGrouping_2();
        //twoLevelGrouping_3();
        //calculteTopGpaStudentinEachGrade();
        //calculteleastGpaStudentinEachGrade();
       // threeArgumentGroupingBy();
    }

}

/*
• groupingBy() collector is equivalent to the groupBy() operation in SQL.
• Used to group the elements based on a property. 
• The output of the groupingBy() is going to be a Map<K,V> 
• There are three different versions of groupingBy(). 
• groupingBy(classifier) 
• groupingBy(classifier,downstream) 
• groupingBy(classifier,supplier,downstream)

{2={AVERAGE=[Student{name='Adam', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball]}], OUTSTANDING=[Student{name='Jenny', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer]}]}, 3={OUTSTANDING=[Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics]}, Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer]}]}, 4={AVERAGE=[Student{name='Sophia', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football]}], OUTSTANDING=[Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football]}]}}

*/