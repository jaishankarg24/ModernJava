package com.learn.java.functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 9
public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>>  function = (students -> {

        Map<String,Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {

            if(PredicateStudentExample.p1.test(student)){
                studentGradeMap.put(student.getName(),student.getGpa());
            }
        }));

        return studentGradeMap;

    });

    public static void main(String[] args) {

        // System.out.println(function.apply(StudentDataBase.getAllStudents()));
        
         function.apply(StudentDataBase.getAllStudents()).entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()) );

    }

}

/*
{Emily=4.0, James=3.9, Dave=4.0, Sophia=3.5}

Emily = 4.0
James = 3.9
Dave = 4.0
Sophia = 3.5

 */
