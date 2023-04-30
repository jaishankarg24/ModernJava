package com.learn.java.streams.terminalstreams;

import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 5
public class StreamsSumAvgExample {

    public static int sum(){

        int totalNoOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));

        return totalNoOfNotebooks;
    }

    public static double average(){

        double totalNoOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));

        return totalNoOfNotebooks;
    }


    public static void main(String[] args) {


        System.out.println("Total no of Notebooks : " + sum());

        System.out.println("Average no of Notebooks : " + average());
    }

}
/*
• summingInt() – this collector returns the sum as a result. 
• averagingInt() – this collector returns the average as a result.

Total no of Notebooks : 80
Average no of Notebooks : 13.333333333333334
*/