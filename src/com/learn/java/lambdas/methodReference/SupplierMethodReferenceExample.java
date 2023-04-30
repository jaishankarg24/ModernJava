package com.learn.java.lambdas.methodReference;

import java.util.function.Supplier;

import com.learn.java.data.Student;

// 4
public class SupplierMethodReferenceExample {

    Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println();

    }

}
