package com.learn.java.defaultandstatics;

public interface Interface1 {
    default void methodA(){
        System.out.println("Inside method A"+Interface1.class);
    }
}
