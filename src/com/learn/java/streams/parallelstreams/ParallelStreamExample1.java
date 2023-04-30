package com.learn.java.streams.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

// 2
public class ParallelStreamExample1 {

	   public static List<String> sequentialStream(){

	       long start = System.currentTimeMillis();
	        List<String> studentActivities = StudentDataBase.getAllStudents()
	                .stream()
	                .map(Student::getActivities) //Stream<List<String>>
	                .flatMap(List::stream) //<Stream<String>
	                .collect(Collectors.toList());

	       long duration = System.currentTimeMillis()-start;
	       System.out.println("Duration in sequential stream : "+ duration);

	        return studentActivities;
	    }

	    public static List<String> parallelStream(){

	        long start = System.currentTimeMillis();
	        List<String> studentActivities = StudentDataBase.getAllStudents()
	                .parallelStream()
	                .map(Student::getActivities) //Stream<List<String>>
	                .flatMap(List::stream) //<Stream<String>
	                .collect(Collectors.toList());

	        long duration = System.currentTimeMillis()-start;
	        System.out.println("Duration in parallel stream : "+ duration);

	        return studentActivities;

	    }



	    public static void main(String[] args) {


	        System.out.println("sequentialStream : " + sequentialStream());

	        System.out.println("parallelStream : " + parallelStream());


	    }

}
/*
Duration in sequential stream : 114
sequentialStream : [swimming, basketball, volleyball, swimming, gymnastics, soccer, swimming, gymnastics, aerobics, swimming, gymnastics, soccer, swimming, dancing, football, swimming, basketball, baseball, football]
Duration in parallel stream : 6
parallelStream : [swimming, basketball, volleyball, swimming, gymnastics, soccer, swimming, gymnastics, aerobics, swimming, gymnastics, soccer, swimming, dancing, football, swimming, basketball, baseball, football]
*/
